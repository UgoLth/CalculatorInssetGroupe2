// .ui.xml template last modified: 1761296495000
package org.insset.client.calculator.pourcentage;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeUri;
import com.google.gwt.safehtml.shared.UriUtils;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiBinderUtil;
import com.google.gwt.user.client.ui.HTMLPanel;

public class DiscountCalculatorPresenter_DiscountUiBinderImpl implements UiBinder<com.google.gwt.user.client.ui.HTMLPanel, org.insset.client.calculator.pourcentage.DiscountCalculatorPresenter>, org.insset.client.calculator.pourcentage.DiscountCalculatorPresenter.DiscountUiBinder {

  interface Template extends SafeHtmlTemplates {
    @Template("<span id='{0}'></span>")
    SafeHtml html1(String arg0);
     
  }

  Template template = GWT.create(Template.class);


  public com.google.gwt.user.client.ui.HTMLPanel createAndBindUi(final org.insset.client.calculator.pourcentage.DiscountCalculatorPresenter owner) {


    return new Widgets(owner).get_f_HTMLPanel1();
  }

  /**
   * Encapsulates the access to all inner widgets
   */
  class Widgets {
    private final org.insset.client.calculator.pourcentage.DiscountCalculatorPresenter owner;


    public Widgets(final org.insset.client.calculator.pourcentage.DiscountCalculatorPresenter owner) {
      this.owner = owner;
      build_domId0();  // more than one getter call detected. Type: DOM_ID_HOLDER, precedence: 2
      build_domId0Element();  // more than one getter call detected. Type: DEFAULT, precedence: 2
    }

    SafeHtml template_html1() {
      return template.html1(get_domId0());
    }

    /**
     * Getter for clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay called 0 times. Type: GENERATED_BUNDLE. Build precedence: 1.
     */
    private org.insset.client.calculator.pourcentage.DiscountCalculatorPresenter_DiscountUiBinderImpl_GenBundle get_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      return build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay();
    }
    private org.insset.client.calculator.pourcentage.DiscountCalculatorPresenter_DiscountUiBinderImpl_GenBundle build_clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay() {
      // Creation section.
      final org.insset.client.calculator.pourcentage.DiscountCalculatorPresenter_DiscountUiBinderImpl_GenBundle clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay = (org.insset.client.calculator.pourcentage.DiscountCalculatorPresenter_DiscountUiBinderImpl_GenBundle) GWT.create(org.insset.client.calculator.pourcentage.DiscountCalculatorPresenter_DiscountUiBinderImpl_GenBundle.class);
      // Setup section.

      return clientBundleFieldNameUnlikelyToCollideWithUserSpecifiedFieldOkay;
    }

    /**
     * Getter for f_HTMLPanel1 called 1 times. Type: DEFAULT. Build precedence: 1.
     */
    private com.google.gwt.user.client.ui.HTMLPanel get_f_HTMLPanel1() {
      return build_f_HTMLPanel1();
    }
    private com.google.gwt.user.client.ui.HTMLPanel build_f_HTMLPanel1() {
      // Creation section.
      final com.google.gwt.user.client.ui.HTMLPanel f_HTMLPanel1 = new com.google.gwt.user.client.ui.HTMLPanel(template_html1().asString());
      // Setup section.

      {
        // Attach section.
        UiBinderUtil.TempAttachment __attachRecord__ = UiBinderUtil.attachToDom(f_HTMLPanel1.getElement());

        get_domId0Element().get();

        // Detach section.
        __attachRecord__.detach();
      }
      f_HTMLPanel1.addAndReplaceElement(get_f_VerticalPanel2(), get_domId0Element().get());

      return f_HTMLPanel1;
    }

    /**
     * Getter for domId0 called 2 times. Type: DOM_ID_HOLDER. Build precedence: 2.
     */
    private java.lang.String domId0;
    private java.lang.String get_domId0() {
      return domId0;
    }
    private java.lang.String build_domId0() {
      // Creation section.
      domId0 = com.google.gwt.dom.client.Document.get().createUniqueId();
      // Setup section.

      return domId0;
    }

    /**
     * Getter for f_VerticalPanel2 called 1 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.user.client.ui.VerticalPanel get_f_VerticalPanel2() {
      return build_f_VerticalPanel2();
    }
    private com.google.gwt.user.client.ui.VerticalPanel build_f_VerticalPanel2() {
      // Creation section.
      final com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel2 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
      // Setup section.
      f_VerticalPanel2.add(get_f_HorizontalPanel3());
      f_VerticalPanel2.add(get_f_HorizontalPanel5());
      f_VerticalPanel2.add(get_f_HorizontalPanel7());
      f_VerticalPanel2.add(get_errorLabel());
      f_VerticalPanel2.add(get_f_VerticalPanel8());
      f_VerticalPanel2.setSpacing(8);

      return f_VerticalPanel2;
    }

    /**
     * Getter for f_HorizontalPanel3 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HorizontalPanel get_f_HorizontalPanel3() {
      return build_f_HorizontalPanel3();
    }
    private com.google.gwt.user.client.ui.HorizontalPanel build_f_HorizontalPanel3() {
      // Creation section.
      final com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel3 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
      // Setup section.
      f_HorizontalPanel3.add(get_f_Label4());
      f_HorizontalPanel3.add(get_originalPrice());
      f_HorizontalPanel3.setSpacing(8);

      return f_HorizontalPanel3;
    }

    /**
     * Getter for f_Label4 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label4() {
      return build_f_Label4();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label4() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label4 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label4.setText("Prix original (€) :");

      return f_Label4;
    }

    /**
     * Getter for originalPrice called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.TextBox get_originalPrice() {
      return build_originalPrice();
    }
    private com.google.gwt.user.client.ui.TextBox build_originalPrice() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextBox originalPrice = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
      // Setup section.

      this.owner.originalPrice = originalPrice;

      return originalPrice;
    }

    /**
     * Getter for f_HorizontalPanel5 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HorizontalPanel get_f_HorizontalPanel5() {
      return build_f_HorizontalPanel5();
    }
    private com.google.gwt.user.client.ui.HorizontalPanel build_f_HorizontalPanel5() {
      // Creation section.
      final com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel5 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
      // Setup section.
      f_HorizontalPanel5.add(get_f_Label6());
      f_HorizontalPanel5.add(get_discountRate());
      f_HorizontalPanel5.setSpacing(8);

      return f_HorizontalPanel5;
    }

    /**
     * Getter for f_Label6 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label6() {
      return build_f_Label6();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label6() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label6 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label6.setText("Taux (%) :");

      return f_Label6;
    }

    /**
     * Getter for discountRate called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.TextBox get_discountRate() {
      return build_discountRate();
    }
    private com.google.gwt.user.client.ui.TextBox build_discountRate() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextBox discountRate = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
      // Setup section.

      this.owner.discountRate = discountRate;

      return discountRate;
    }

    /**
     * Getter for f_HorizontalPanel7 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.HorizontalPanel get_f_HorizontalPanel7() {
      return build_f_HorizontalPanel7();
    }
    private com.google.gwt.user.client.ui.HorizontalPanel build_f_HorizontalPanel7() {
      // Creation section.
      final com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel7 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
      // Setup section.
      f_HorizontalPanel7.add(get_calculateButton());
      f_HorizontalPanel7.add(get_clearButton());
      f_HorizontalPanel7.setSpacing(8);

      return f_HorizontalPanel7;
    }

    /**
     * Getter for calculateButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.SubmitButton get_calculateButton() {
      return build_calculateButton();
    }
    private com.google.gwt.user.client.ui.SubmitButton build_calculateButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.SubmitButton calculateButton = (com.google.gwt.user.client.ui.SubmitButton) GWT.create(com.google.gwt.user.client.ui.SubmitButton.class);
      // Setup section.
      calculateButton.setText("Calculer");

      this.owner.calculateButton = calculateButton;

      return calculateButton;
    }

    /**
     * Getter for clearButton called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.ResetButton get_clearButton() {
      return build_clearButton();
    }
    private com.google.gwt.user.client.ui.ResetButton build_clearButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.ResetButton clearButton = (com.google.gwt.user.client.ui.ResetButton) GWT.create(com.google.gwt.user.client.ui.ResetButton.class);
      // Setup section.
      clearButton.setText("Effacer");

      this.owner.clearButton = clearButton;

      return clearButton;
    }

    /**
     * Getter for errorLabel called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.Label get_errorLabel() {
      return build_errorLabel();
    }
    private com.google.gwt.user.client.ui.Label build_errorLabel() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label errorLabel = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.

      this.owner.errorLabel = errorLabel;

      return errorLabel;
    }

    /**
     * Getter for f_VerticalPanel8 called 1 times. Type: DEFAULT. Build precedence: 3.
     */
    private com.google.gwt.user.client.ui.VerticalPanel get_f_VerticalPanel8() {
      return build_f_VerticalPanel8();
    }
    private com.google.gwt.user.client.ui.VerticalPanel build_f_VerticalPanel8() {
      // Creation section.
      final com.google.gwt.user.client.ui.VerticalPanel f_VerticalPanel8 = (com.google.gwt.user.client.ui.VerticalPanel) GWT.create(com.google.gwt.user.client.ui.VerticalPanel.class);
      // Setup section.
      f_VerticalPanel8.add(get_f_Label9());
      f_VerticalPanel8.add(get_f_HorizontalPanel10());
      f_VerticalPanel8.add(get_divisionResult());
      f_VerticalPanel8.setSpacing(8);

      return f_VerticalPanel8;
    }

    /**
     * Getter for f_Label9 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label9() {
      return build_f_Label9();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label9() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label9 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label9.setText("Division de deux nombres entiers");

      return f_Label9;
    }

    /**
     * Getter for f_HorizontalPanel10 called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.HorizontalPanel get_f_HorizontalPanel10() {
      return build_f_HorizontalPanel10();
    }
    private com.google.gwt.user.client.ui.HorizontalPanel build_f_HorizontalPanel10() {
      // Creation section.
      final com.google.gwt.user.client.ui.HorizontalPanel f_HorizontalPanel10 = (com.google.gwt.user.client.ui.HorizontalPanel) GWT.create(com.google.gwt.user.client.ui.HorizontalPanel.class);
      // Setup section.
      f_HorizontalPanel10.add(get_f_Label11());
      f_HorizontalPanel10.add(get_divA());
      f_HorizontalPanel10.add(get_f_Label12());
      f_HorizontalPanel10.add(get_divB());
      f_HorizontalPanel10.add(get_divideButton());
      f_HorizontalPanel10.add(get_clearDivisionButton());
      f_HorizontalPanel10.setSpacing(8);

      return f_HorizontalPanel10;
    }

    /**
     * Getter for f_Label11 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label11() {
      return build_f_Label11();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label11() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label11 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label11.setText("A :");

      return f_Label11;
    }

    /**
     * Getter for divA called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.TextBox get_divA() {
      return build_divA();
    }
    private com.google.gwt.user.client.ui.TextBox build_divA() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextBox divA = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
      // Setup section.
      divA.setWidth("60px");

      this.owner.divA = divA;

      return divA;
    }

    /**
     * Getter for f_Label12 called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.Label get_f_Label12() {
      return build_f_Label12();
    }
    private com.google.gwt.user.client.ui.Label build_f_Label12() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label f_Label12 = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.
      f_Label12.setText("B :");

      return f_Label12;
    }

    /**
     * Getter for divB called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.TextBox get_divB() {
      return build_divB();
    }
    private com.google.gwt.user.client.ui.TextBox build_divB() {
      // Creation section.
      final com.google.gwt.user.client.ui.TextBox divB = (com.google.gwt.user.client.ui.TextBox) GWT.create(com.google.gwt.user.client.ui.TextBox.class);
      // Setup section.
      divB.setWidth("60px");

      this.owner.divB = divB;

      return divB;
    }

    /**
     * Getter for divideButton called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.SubmitButton get_divideButton() {
      return build_divideButton();
    }
    private com.google.gwt.user.client.ui.SubmitButton build_divideButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.SubmitButton divideButton = (com.google.gwt.user.client.ui.SubmitButton) GWT.create(com.google.gwt.user.client.ui.SubmitButton.class);
      // Setup section.
      divideButton.setText("Diviser");

      this.owner.divideButton = divideButton;

      return divideButton;
    }

    /**
     * Getter for clearDivisionButton called 1 times. Type: DEFAULT. Build precedence: 5.
     */
    private com.google.gwt.user.client.ui.ResetButton get_clearDivisionButton() {
      return build_clearDivisionButton();
    }
    private com.google.gwt.user.client.ui.ResetButton build_clearDivisionButton() {
      // Creation section.
      final com.google.gwt.user.client.ui.ResetButton clearDivisionButton = (com.google.gwt.user.client.ui.ResetButton) GWT.create(com.google.gwt.user.client.ui.ResetButton.class);
      // Setup section.
      clearDivisionButton.setText("Effacer");

      this.owner.clearDivisionButton = clearDivisionButton;

      return clearDivisionButton;
    }

    /**
     * Getter for divisionResult called 1 times. Type: DEFAULT. Build precedence: 4.
     */
    private com.google.gwt.user.client.ui.Label get_divisionResult() {
      return build_divisionResult();
    }
    private com.google.gwt.user.client.ui.Label build_divisionResult() {
      // Creation section.
      final com.google.gwt.user.client.ui.Label divisionResult = (com.google.gwt.user.client.ui.Label) GWT.create(com.google.gwt.user.client.ui.Label.class);
      // Setup section.

      this.owner.divisionResult = divisionResult;

      return divisionResult;
    }

    /**
     * Getter for domId0Element called 2 times. Type: DEFAULT. Build precedence: 2.
     */
    private com.google.gwt.uibinder.client.LazyDomElement domId0Element;
    private com.google.gwt.uibinder.client.LazyDomElement get_domId0Element() {
      return domId0Element;
    }
    private com.google.gwt.uibinder.client.LazyDomElement build_domId0Element() {
      // Creation section.
      domId0Element = new com.google.gwt.uibinder.client.LazyDomElement<Element>(get_domId0());
      // Setup section.

      return domId0Element;
    }
  }
}
