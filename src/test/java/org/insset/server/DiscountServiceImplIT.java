/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author insset
 */
public class DiscountServiceImplIT {

    @Test
    public void calcule_remise_classique() {
        DiscountServiceImpl svc = new DiscountServiceImpl();
        Double[] out = svc.calculateDiscount(200.0, 15); // 15% de 200 = 30
        assertEquals(30.0, out[0], 1e-9);  // remise
        assertEquals(170.0, out[1], 1e-9); // final
    }
    @Test
    public void taux_1_pourcent() {
        DiscountServiceImpl svc = new DiscountServiceImpl();
        Double[] out = svc.calculateDiscount(100.0, 1);
        assertEquals(1.0, out[0], 1e-9);
        assertEquals(99.0, out[1], 1e-9);
    }
    @Test
    public void taux_100_pourcent() {
        DiscountServiceImpl svc = new DiscountServiceImpl();
        Double[] out = svc.calculateDiscount(50.0, 100);
        assertEquals(50.0, out[0], 1e-9);
        assertEquals(0.0, out[1], 1e-9);
    }
    @Test(expected = IllegalArgumentException.class)
    public void prix_invalide_zero() {
        new DiscountServiceImpl().calculateDiscount(0.0, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void taux_negatif() {
        new DiscountServiceImpl().calculateDiscount(100.0, -1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void taux_superieur_100() {
        new DiscountServiceImpl().calculateDiscount(100.0, 101);
    }
    
    @Test
    public void division_simple_entiers() {
        double res = org.insset.shared.MathUtils.divideInts(10, 2);
        assertEquals(5.0, res, 1e-9);
    }

    @Test
    public void division_non_entière() {
        double res = org.insset.shared.MathUtils.divideInts(7, 2);
        assertEquals(3.5, res, 1e-9);
    }
    
    @Test
    public void division_negative() {
        double res = org.insset.shared.MathUtils.divideInts(-9, 3);
        assertEquals(-3.0, res, 1e-9);
    }

    @Test(expected = IllegalArgumentException.class)
    public void division_par_zero_declenche_exception() {
        org.insset.shared.MathUtils.divideInts(12, 0);
    }
}