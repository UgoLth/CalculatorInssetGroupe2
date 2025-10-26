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

    @Override
    public Double calculateOriginalPrice(Double finalPrice, Integer discountRate)
            throws IllegalArgumentException {
        if (finalPrice == null || finalPrice <= 0) {
            throw new IllegalArgumentException("Prix final invalide (doit être > 0)");
        }
        if (discountRate == null || discountRate < 0 || discountRate >= 100) {
            // 100% would cause division by zero; not supported to infer unique original price
            throw new IllegalArgumentException("Taux invalide (0-99%)");
        }

        double factor = 1.0 - (discountRate / 100.0);
        double original = finalPrice / factor;
        return original;
    }
}
 
