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
public class RomanConverterServiceImplIT {
    private RomanConverterServiceImpl instance;
    
    public RomanConverterServiceImplIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new RomanConverterServiceImpl();
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void testConvertRomanToArabe_ValidNumbers() {
        System.out.println("convertRomanToArabe - Nombres valides");
        
        // Test cas simples
        assertEquals(Integer.valueOf(1), instance.convertRomanToArabe("I"));
        assertEquals(Integer.valueOf(5), instance.convertRomanToArabe("V"));
        assertEquals(Integer.valueOf(10), instance.convertRomanToArabe("X"));
        assertEquals(Integer.valueOf(50), instance.convertRomanToArabe("L"));
        assertEquals(Integer.valueOf(100), instance.convertRomanToArabe("C"));
        assertEquals(Integer.valueOf(500), instance.convertRomanToArabe("D"));
        assertEquals(Integer.valueOf(1000), instance.convertRomanToArabe("M"));
        
        assertEquals(Integer.valueOf(4), instance.convertRomanToArabe("IV"));
        assertEquals(Integer.valueOf(9), instance.convertRomanToArabe("IX"));
        assertEquals(Integer.valueOf(40), instance.convertRomanToArabe("XL"));
        assertEquals(Integer.valueOf(90), instance.convertRomanToArabe("XC"));
        assertEquals(Integer.valueOf(400), instance.convertRomanToArabe("CD"));
        assertEquals(Integer.valueOf(900), instance.convertRomanToArabe("CM"));
        
        assertEquals(Integer.valueOf(14), instance.convertRomanToArabe("XIV"));
        assertEquals(Integer.valueOf(49), instance.convertRomanToArabe("XLIX"));
        assertEquals(Integer.valueOf(99), instance.convertRomanToArabe("XCIX"));
        assertEquals(Integer.valueOf(444), instance.convertRomanToArabe("CDXLIV"));
        assertEquals(Integer.valueOf(1990), instance.convertRomanToArabe("MCMXC"));
        assertEquals(Integer.valueOf(2000), instance.convertRomanToArabe("MM"));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testConvertRomanToArabe_InvalidCharacters() {
        System.out.println("convertRomanToArabe - Caractères invalides");
        instance.convertRomanToArabe("ABC");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertRomanToArabe_EmptyString() {
        System.out.println("convertRomanToArabe - Chaîne vide");
        instance.convertRomanToArabe("");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testConvertRomanToArabe_InvalidCombination() {
        System.out.println("convertRomanToArabe - Combinaison invalide");
        instance.convertRomanToArabe("IIII"); // 4 I consécutifs interdits
    }
    @Test(expected = IllegalArgumentException.class)
    public void testConvertRomanToArabe_OutOfRange() {
        System.out.println("convertRomanToArabe - Hors limites");
        // Ce test échouera si le nombre dépasse 2000
        instance.convertRomanToArabe("MMI"); // 2001
    }
    @Test
    public void testConvertArabeToRoman_ValidNumbers() {
        System.out.println("convertArabeToRoman - Nombres valides");
        
        // Test cas simples
        assertEquals("I", instance.convertArabeToRoman(1));
        assertEquals("V", instance.convertArabeToRoman(5));
        assertEquals("X", instance.convertArabeToRoman(10));
        assertEquals("L", instance.convertArabeToRoman(50));
        assertEquals("C", instance.convertArabeToRoman(100));
        assertEquals("D", instance.convertArabeToRoman(500));
        assertEquals("M", instance.convertArabeToRoman(1000));
        
        assertEquals("IV", instance.convertArabeToRoman(4));
        assertEquals("IX", instance.convertArabeToRoman(9));
        assertEquals("XL", instance.convertArabeToRoman(40));
        assertEquals("XC", instance.convertArabeToRoman(90));
        assertEquals("CD", instance.convertArabeToRoman(400));
        assertEquals("CM", instance.convertArabeToRoman(900));
        
        assertEquals("XIV", instance.convertArabeToRoman(14));
        assertEquals("XLIX", instance.convertArabeToRoman(49));
        assertEquals("XCIX", instance.convertArabeToRoman(99));
        assertEquals("CDXLIV", instance.convertArabeToRoman(444));
        assertEquals("MCMXC", instance.convertArabeToRoman(1990));
        assertEquals("MM", instance.convertArabeToRoman(2000));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testConvertArabeToRoman_Zero() {
        System.out.println("convertArabeToRoman - Zéro");
        instance.convertArabeToRoman(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertArabeToRoman_Negative() {
        System.out.println("convertArabeToRoman - Négatif");
        instance.convertArabeToRoman(-1);
    }
     @Test(expected = IllegalArgumentException.class)
    public void testConvertArabeToRoman_AboveLimit() {
        System.out.println("convertArabeToRoman - Au-dessus de 2000");
        instance.convertArabeToRoman(2001);
    }
    
    /**
     * Test of convertDateYears method, of class RomanConverterServiceImpl.
     */
    @Test
    public void testConvertDateYears_ValidDates() {
        System.out.println("convertDateYears - Dates valides");
        assertEquals("I/I/MMXXIV", instance.convertDateYears("1/1/2024"));
        assertEquals("XV/III/MM", instance.convertDateYears("15/3/2000"));
        assertEquals("XXV/XII/MCMXC", instance.convertDateYears("25/12/1990"));
        assertEquals("XIV/VII/MDCCCLX", instance.convertDateYears("14/7/1860"));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testConvertDateYears_InvalidFormat() {
        System.out.println("convertDateYears - Format invalide");
        instance.convertDateYears("15-03-2024");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testConvertDateYears_InvalidDate() {
        System.out.println("convertDateYears - Date invalide");
        instance.convertDateYears("32/13/2024");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testConvertDateYears_EmptyString() {
        System.out.println("convertDateYears - Chaîne vide");
        instance.convertDateYears("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertDateYears_NonNumeric() {
        System.out.println("convertDateYears - Caractères non numériques");
        instance.convertDateYears("AA/BB/CCCC");
    }
    @Test
public void testConvertDateYears_EdgeCases() {
    System.out.println("convertDateYears - Cas limites");
    
    assertEquals("XV/III/MM", instance.convertDateYears("15/03/2000"));
    assertEquals("XXV/XII/MCMXC", instance.convertDateYears("25/12/1990"));
}
    
}
    