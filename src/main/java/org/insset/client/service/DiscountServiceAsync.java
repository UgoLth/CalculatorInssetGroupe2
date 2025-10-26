/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DiscountServiceAsync {
    void calculateDiscount(Double originalPrice, Integer discountRate,
                           AsyncCallback<Double[]> callback);

    void calculateOriginalPrice(Double finalPrice, Integer discountRate,
                                AsyncCallback<Double> callback);
}
