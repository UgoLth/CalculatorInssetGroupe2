package org.insset.shared;

/**
 * <p>
 * FieldVerifier validates that the name the user enters is valid.
 * </p>
 * <p>
 * This class is in the <code>shared</code> packing because we use it in both
 * the client code and on the server. On the client, we verify that the name is
 * valid before sending an RPC request so the user doesn't have to wait for a
 * network round trip to get feedback. On the server, we verify that the name is
 * correct to ensure that the input is correct regardless of where the RPC
 * originates.
 * </p>
 * <p>
 * When creating a class that is used on both the client and the server, be sure
 * that all code is translatable and does not use native JavaScript. Code that
 * is note translatable (such as code that interacts with a database or the file
 * system) cannot be compiled into client side JavaScript. Code that uses native
 * JavaScript (such as Widgets) cannot be run on the server.
 * </p>
 */
public class FieldVerifier {

    /**
     * Verifies that the specified name is valid for our service.
     *
     * In this example, we only require that the name is at least four
     * characters. In your application, you can use more complex checks to
     * ensure that usernames, passwords, email addresses, URLs, and other fields
     * have the proper syntax.
     *
     * @param name the name to validate
     * @return true if valid, false if invalid
     */
    public static boolean isValidName(String name) {
        if ((name == null) || (name.isEmpty())) {
            return false;
        }
        return true;
    }

    /**
     * Verifies that the specified value is valide.
     *
     * In this example, we only require that the name is at least four
     * characters. In your application, you can use more complex checks to
     * ensure that usernames, passwords, email addresses, URLs, and other fields
     * have the proper syntax.
     *
     * @param name the name to validate
     * @return true if valid, false if invalid
     */
    public static boolean isValidDecimal(Integer nbr) {
        if (nbr == null) {
            return false;
        }
        return nbr >= 1 && nbr <= 2000;
    }

    public static boolean isValidRoman(String nbr) {
        if (nbr == null || nbr.trim().isEmpty()){
            return false;
        }
        String romanPattern = "^[IVXLCDMivxlcdm]+$";
        if (!nbr.matches(romanPattern)) {
            return false;
        }
        
        String roman = nbr.toUpperCase();
        
        if (roman.matches(".*IIII.*") || roman.matches(".*XXXX.*") || 
            roman.matches(".*CCCC.*") || roman.matches(".*VV.*") || 
            roman.matches(".*LL.*") || roman.matches(".*DD.*")) {
            return false;
        }
        
        if (roman.contains("IL") || roman.contains("IC") || roman.contains("ID") || roman.contains("IM") ||
            roman.contains("VX") || roman.contains("VL") || roman.contains("VC") || roman.contains("VD") || roman.contains("VM") ||
            roman.contains("XD") || roman.contains("XM") || roman.contains("LC") || roman.contains("LD") || roman.contains("LM") ||
            roman.contains("DM")) {
            return false;
        }
        
        return true;
    }

    public static boolean isValidDate(String date) {
        if (date == null || date.trim().isEmpty()){
            return false;
        }
        String datePattern = "^\\d{1,2}/\\d{1,2}/\\d{4}$";
        if (!date.matches(datePattern)) {
            return false;
        }
        
        try {
            String[] parts = date.split("/");
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);
            
            // Validation des plages de dates
            if (day < 1 || day > 31) {
                return false;
            }
            if (month < 1 || month > 12) {
                return false;
            }
            if (year < 1 || year > 3999) {
                return false;
            }
            
            // Validation des mois avec 30 jours
            if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
                return false;
            }
            if (month == 2) {
                boolean isLeapYear = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
                if (isLeapYear && day > 29) {
                    return false;
                }
                if (!isLeapYear && day > 28) {
                    return false;
                }
            }
            return true;
        }catch (NumberFormatException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
