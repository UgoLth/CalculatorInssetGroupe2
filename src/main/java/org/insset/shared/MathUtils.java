/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.shared;

/**
 *
 * @author insset
 */
public class MathUtils {
    
    private MathUtils() {}

    public static double divideInts(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division par zéro interdite");
        }
        return (double) a / (double) b;
    }
}
