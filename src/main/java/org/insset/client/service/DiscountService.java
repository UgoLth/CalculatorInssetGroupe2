/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 *
 * @author insset
 */
@RemoteServiceRelativePath("discount")
public interface DiscountService extends RemoteService {
    Double[] calculateDiscount(Double originalPrice, Integer discountRate)
        throws IllegalArgumentException;
    
    /**
     * Compute the original price from a final (discounted) price and a discount rate.
     * @param finalPrice the discounted price (must be > 0)
     * @param discountRate the discount percent between 0 and 99
     * @return the original price before discount
     * @throws IllegalArgumentException when inputs are invalid
     */
    Double calculateOriginalPrice(Double finalPrice, Integer discountRate)
        throws IllegalArgumentException;
              
}
