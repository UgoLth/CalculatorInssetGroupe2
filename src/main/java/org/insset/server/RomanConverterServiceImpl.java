/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.insset.client.service.RomanConverterService;
import org.insset.shared.FieldVerifier;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author user
 */

@SuppressWarnings("serial")
public class RomanConverterServiceImpl extends RemoteServiceServlet implements
        RomanConverterService {
    @Override
        public Integer convertRomanToArabe(String nbr) throws IllegalArgumentException {
            // Validation du chiffre romain
            if (!FieldVerifier.isValidRoman(nbr)) {
                throw new IllegalArgumentException("Chiffre romain invalide : " + nbr);
            }
            
            String roman = nbr.toUpperCase();
            int result = romanToArabic(roman);
            
            if (result < 1 || result > 2000) {
            throw new IllegalArgumentException("Le nombre doit être entre 1 et 2000. Valeur obtenue : " + result);
            }
            return result;
        }
        @Override
        public String convertArabeToRoman(Integer nbr) throws IllegalArgumentException {
        // Validation du nombre arabe
              if (nbr == null || nbr < 1 || nbr > 2000) {
                throw new IllegalArgumentException("Le nombre doit être entre 1 et 2000");
            }
              
            return arabicToRoman(nbr);
        }
        @Override
        public String convertDateYears(String date) throws IllegalArgumentException {
            if (!FieldVerifier.isValidDate(date)) {
                throw new IllegalArgumentException("Format de date invalide. Utilisez JJ/MM/AAAA");
            }
            String[] parts = date.split("/");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Format de date invalide");
            }
            try {
                int day = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int year = Integer.parseInt(parts[2]);
                if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1 || year > 3999) {
                    throw new IllegalArgumentException("Date invalide");
                }
                String romanDay = arabicToRoman(day);
                String romanMonth = arabicToRoman(month);
                String romanYear = arabicToRoman(year);
                return romanDay + "/" + romanMonth + "/" + romanYear;
            }
            catch (NumberFormatException e) {
                throw new IllegalArgumentException("La date contient des caractères non numériques");
            }
        }
        
        private int romanToArabic(String roman) {
            Map<Character, Integer> values = new HashMap<>();
            values.put('I', 1);
            values.put('V', 5);
            values.put('X', 10);
            values.put('L', 50);
            values.put('C', 100);
            values.put('D', 500);
            values.put('M', 1000);
            
            int result = 0;
            int previousValue = 0;
            
            for (int i = roman.length() - 1; i >= 0; i--) {
                char c = roman.charAt(i);
                Integer currentValue = values.get(c);
            
                if (currentValue == null) {
                    throw new IllegalArgumentException("Caractère romain invalide : " + c);
                }
                if (currentValue < previousValue) {
                    result -= currentValue;
                }else {
                    result += currentValue;
                }
                previousValue = currentValue;
            }
            return result;
        }
        
        private String arabicToRoman(int number) {
            if (number < 1 || number > 3999) {
                throw new IllegalArgumentException("Le nombre doit être entre 1 et 3999");
            }
            String[] milliers = {"", "M", "MM", "MMM"};
            String[] centaines = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
            String[] dizaines = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
            String[] unites = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
            
            return milliers[number / 1000] + 
                centaines[(number % 1000) / 100] + 
                dizaines[(number % 100) / 10] + 
                unites[number % 10];
        }
    }
        