/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;


import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.insset.client.service.DiscountService;
/**
 *
 * @author insset
 */
public class DiscountServiceImpl extends RemoteServiceServlet implements DiscountService {

    @Override
    public Double[] calculateDiscount(Double originalPrice, Integer discountRate)
            throws IllegalArgumentException {
        if (originalPrice == null || originalPrice <= 0) {
            throw new IllegalArgumentException("Prix invalide (doit être > 0)");
        }
        if (discountRate == null || discountRate < 0 || discountRate > 100) {
            throw new IllegalArgumentException("Taux invalide (0-100%)");
        }
        
        double discount = originalPrice * discountRate / 100.0;
        double finalPrice = originalPrice - discount;

        return new Double[]{ discount, finalPrice };
    }
}
 