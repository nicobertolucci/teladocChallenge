package com.company;

import java.math.BigInteger;

class Main {
    /*
        Write a function that adds two strings, where each string represents an  arbitrarily large non-negative number.

        function String addNumbers(String str1, String str2)

        Examples:
        - addNumbers("123456789012345678901", "12345678") should return  "123456789012358024579".
        - addNumbers("123", "11") should return "134".
    */
    public static void main(String[] args) {
        System.out.println(addNumbers("123456789012345678901","12345678"));
        System.out.println(addNumbers("123","11"));

    }

    private static String addNumbers(String str1, String str2){
        if (str1.startsWith("-") || str2.startsWith("-")) {
            throw new IllegalArgumentException("Numbers cannot be negative");
        }
        // Reverse number for start making the add for the unit
        String reverseNumber1 = new StringBuilder(str1).reverse().toString();
        String reverseNumber2 = new StringBuilder(str2).reverse().toString();

        // Check max length of numbers
        int maxLength = Math.max(str1.length(),str2.length());
        StringBuilder result = new StringBuilder(maxLength + 1); // Create a StringBuilder to store the result, the length is the maximum length + 1 (in case the result has an extra digit)

        int addNextDigit = 0; // Store the value to send next digit

        for (int i=0; i < maxLength; i++){
            int digit1 = i < reverseNumber1.length() ? Character.getNumericValue(reverseNumber1.charAt(i)) : 0; // get number for position or 0 if it doesn't exists
            int digit2 = i < reverseNumber2.length() ? Character.getNumericValue(reverseNumber2.charAt(i)) : 0;

            int sumResult = digit1 + digit2 + addNextDigit; // obtain sum + the next digit from before sum.
            addNextDigit = sumResult / 10; // get the value (if the case) for adding next digit
            int digit = sumResult % 10; // get value without addNextDigit.

            result.append(digit);
        }

        if(addNextDigit != 0) { //Add one digit more if the sum required
            result.append(addNextDigit);
        }

        //return the result reverse.
        return result.reverse().toString();
    }


    public static String addNumbersBigInteger(String num1, String num2) {
        BigInteger bigNum1 = new BigInteger(num1);
        BigInteger bigNum2 = new BigInteger(num2);
        BigInteger result = bigNum1.add(bigNum2);
        return result.toString();
    }


}