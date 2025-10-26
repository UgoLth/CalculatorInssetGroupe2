/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.client.calculator.pourcentage;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ResetButton;
import com.google.gwt.user.client.ui.SubmitButton;
import com.google.gwt.user.client.ui.TextBox;
import org.insset.client.message.dialogbox.DialogBoxInssetPresenter;
import org.insset.client.service.DiscountService;
import org.insset.client.service.DiscountServiceAsync;
import com.google.gwt.i18n.client.NumberFormat;
/**
 *
 * @author insset
 */
public class DiscountCalculatorPresenter extends Composite {
    
    @UiField
    public TextBox originalPrice;
    @UiField
    public TextBox discountRate;
    @UiField
    public SubmitButton calculateButton;
    @UiField
    public ResetButton clearButton;
    @UiField
    public Label errorLabel;
    
    // Champs pour calcul inverse (prix initial)
    @UiField public TextBox finalPrice;
    @UiField public TextBox reverseDiscountRate;
    @UiField public SubmitButton calculateOriginalButton;
    @UiField public ResetButton clearOriginalButton;
    @UiField public Label errorLabelOriginal;
    
    @UiField public TextBox divA;
    @UiField public TextBox divB;
    @UiField public SubmitButton divideButton;
    @UiField public Label divisionResult;
    @UiField public ResetButton clearDivisionButton;

    
    private final DiscountServiceAsync service = GWT.create(DiscountService.class);

    interface DiscountUiBinder extends UiBinder<HTMLPanel, DiscountCalculatorPresenter> {
    }
    
    private static DiscountUiBinder ourUiBinder = GWT.create(DiscountUiBinder.class);

    public DiscountCalculatorPresenter() {
        initWidget(ourUiBinder.createAndBindUi(this));
        initHandler();
        initPlaceholders();
    }
    private void initPlaceholders() {
    originalPrice.getElement().setPropertyString("placeholder", "Prix original (€)");
    discountRate.getElement().setPropertyString("placeholder", "Taux de remise (%)");
    if (finalPrice != null) {
        finalPrice.getElement().setPropertyString("placeholder", "Prix final €\n");
    }
    if (reverseDiscountRate != null) {
        reverseDiscountRate.getElement().setPropertyString("placeholder", "Taux de remise (%)");
    }
    
    divA.getElement().setPropertyString("placeholder", "Premier entier");
    divB.getElement().setPropertyString("placeholder", "Deuxième entier");
    }
    
    private void initHandler() {
        clearButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                originalPrice.setText("");
                discountRate.setText("");
                errorLabel.setText("");
            }
        });
        
        clearDivisionButton.addClickHandler(new ClickHandler() {  // <<--- NOUVEAU
            @Override
            public void onClick(ClickEvent event) {
                divA.setText("");
                divB.setText("");
                divisionResult.setText("");
                divisionResult.removeStyleName("serverResponseLabelError");
            }
        });
        calculateButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                calculateDiscount();
            }
        });
        
        if (clearOriginalButton != null) {
            clearOriginalButton.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    finalPrice.setText("");
                    reverseDiscountRate.setText("");
                    errorLabelOriginal.setText("");
                    errorLabelOriginal.removeStyleName("serverResponseLabelError");
                }
            });
        }
        if (calculateOriginalButton != null) {
            calculateOriginalButton.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    calculateOriginal();
                }
            });
        }
        
         divideButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                calculateDivision();
            }
        });
    }
    private void calculateDiscount() {
        errorLabel.setText("");
        

        Double price = null;
        try {
            price = Double.parseDouble(originalPrice.getText());
            if (price <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            errorLabel.addStyleName("serverResponseLabelError");
            errorLabel.setText("Prix invalide (doit etre > 0)");
            return;
        }
        
        Integer rate = null;
        try {
            rate = Integer.parseInt(discountRate.getText());
            if (rate < 0 || rate > 100) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            errorLabel.addStyleName("serverResponseLabelError");
            errorLabel.setText("Taux invalide (0-100%)");
            return;
        }
        final Double priceVal = price;
        final Integer rateVal = rate;
        
        service.calculateDiscount(price, rate, new AsyncCallback<Double[]>() {
            public void onFailure(Throwable caught) {
                errorLabel.addStyleName("serverResponseLabelError");
                errorLabel.setText("Erreur serveur: " + caught.getMessage());
            }
            public void onSuccess(Double[] result) {
                NumberFormat money = NumberFormat.getFormat("0.00");

                String message =
                    "Prix original: " + money.format(priceVal) + "€\n" +
                    "Montant remise: " + money.format(result[0]) + "€\n" +
                    "Prix final: "   + money.format(result[1]) + "€";

                new DialogBoxInssetPresenter(
                    "Calcul de remise",
                    "Prix: " + money.format(priceVal) + "€, Remise: " + rateVal + "%",
                    message
                );
            }
        });
    }

    private void calculateOriginal() {

        if (errorLabelOriginal != null) {
            errorLabelOriginal.setText("");
            errorLabelOriginal.removeStyleName("serverResponseLabelError");
        }

        Double fPrice = null;
        try {
            fPrice = Double.parseDouble(finalPrice.getText());
            if (fPrice <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            if (errorLabelOriginal != null) {
                errorLabelOriginal.addStyleName("serverResponseLabelError");
                errorLabelOriginal.setText("Prix final invalide (doit etre > 0)");
            }
            return;
        }

        Integer rate = null;
        try {
            rate = Integer.parseInt(reverseDiscountRate.getText());
            if (rate < 0 || rate >= 100) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            if (errorLabelOriginal != null) {
                errorLabelOriginal.addStyleName("serverResponseLabelError");
                errorLabelOriginal.setText("Taux invalide (0-99%)");
            }
            return;
        }

        final Double finalVal = fPrice;
        final Integer rateVal = rate;

        service.calculateOriginalPrice(finalVal, rateVal, new AsyncCallback<Double>() {
            public void onFailure(Throwable caught) {
                if (errorLabelOriginal != null) {
                    errorLabelOriginal.addStyleName("serverResponseLabelError");
                    errorLabelOriginal.setText("Erreur serveur: " + caught.getMessage());
                }
            }
            public void onSuccess(Double original) {
                NumberFormat money = NumberFormat.getFormat("0.00");
                String message =
                    "Prix final: " + money.format(finalVal) + "€\n" +
                    "Taux remise: " + rateVal + "%\n" +
                    "Prix initial: " + money.format(original) + "€\n";

                new DialogBoxInssetPresenter(
                    "Prix initial",
                    "Retrouver le prix initial",
                    message
                );
            }
        });
    }

    private void calculateDivision() {

        divisionResult.setText("");
        divisionResult.removeStyleName("serverResponseLabelError");

        Integer aVal;
        Integer bVal;
        
        try {
            aVal = Integer.parseInt(divA.getText());
            bVal = Integer.parseInt(divB.getText());
        } catch (NumberFormatException e) {
            String err = "Erreur : valeurs non entières";
            divisionResult.setText(err);
            divisionResult.addStyleName("serverResponseLabelError");

            return;
        }
    
        if (bVal == 0) {
            String err = "Erreur : division par 0 impossible";
            divisionResult.setText(err);
            divisionResult.addStyleName("serverResponseLabelError");

            return;
        }
    
        double res = (double) aVal / (double) bVal;
        NumberFormat fmt = NumberFormat.getFormat("0.###");
        String valeurFormatee = fmt.format(res);

        divisionResult.setText("");
        divisionResult.removeStyleName("serverResponseLabelError");
    
        String titre   = "Division de deux entiers";
        String sousTit = aVal + " ÷ " + bVal;
        String corps   = "Résultat : " + valeurFormatee;

        new DialogBoxInssetPresenter(titre, sousTit, corps);
    }     
}
