package com.sedykh.string;

/**
 * 65. Valid Number Given a string s, return whether s is a valid number.
 * <p>
 * For example, all the following are valid numbers: "2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7",
 * "+6e-1", "53.5e93", "-123.456e789", while the following are not valid numbers: "abc", "1a", "1e", "e3", "99e2.5",
 * "--6", "-+3", "95a54e53".
 * <p>
 * Formally, a valid number is defined using one of the following definitions:
 * <p>
 * An integer number followed by an optional exponent. A decimal number followed by an optional exponent. An integer
 * number is defined with an optional sign '-' or '+' followed by digits.
 * <p>
 * A decimal number is defined with an optional sign '-' or '+' followed by one of the following definitions:
 * <p>
 * Digits followed by a dot '.'. Digits followed by a dot '.' followed by digits. A dot '.' followed by digits. An
 * exponent is defined with an exponent notation 'e' or 'E' followed by an integer number.
 * <p>
 * The digits are defined as one or more digits.
 */
public class IsNumber {

    public boolean isNumber(String s) {
        char[] chars = s.toCharArray();
        boolean exponentUsed = false;
        boolean dotUsed = false;
        int digitsCount = 0;
        Character prevChar = null;
        for (final char aChar : chars) {
            switch (aChar) {
                case '-', '+' -> {
                    if (prevChar != null && !(prevChar.equals('e') || prevChar.equals('E'))) {
                        return false;
                    }
                }
                case '.' -> {
                    if (dotUsed || exponentUsed) {
                        return false;
                    }
                    dotUsed = true;
                }
                case 'e', 'E' -> {
                    if (exponentUsed || prevChar == null || !(digitsCount != 0 && (prevChar.equals('.') || Character.isDigit(prevChar)))) {
                        return false;
                    }
                    exponentUsed = true;
                }
                case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> digitsCount++;
                default -> {
                    return false;
                }
            }
            prevChar = aChar;
        }

        if (prevChar.equals('e') || prevChar.equals('E') || prevChar.equals('-') || prevChar.equals('+')) {
            return false;
        }

        if (dotUsed && digitsCount == 0) {
            return false;
        }

        return true;
    }

    public static class MySolution {

        public boolean isNumber(String s) {
            char[] chars = s.toCharArray();
            boolean exponentUsed = false;
            boolean dotUsed = false;
            int digitsCount = 0;
            Character prevChar = null;
            for (final char aChar : chars) {
                switch (aChar) {
                    case '-', '+' -> {
                        if (prevChar != null && !(prevChar.equals('e') || prevChar.equals('E'))) {
                            return false;
                        }
                    }
                    case '.' -> {
                        if (dotUsed || exponentUsed) {
                            return false;
                        }
                        dotUsed = true;
                    }
                    case 'e', 'E' -> {
                        if (exponentUsed || prevChar == null || !(digitsCount != 0 && (prevChar.equals('.') || Character.isDigit(prevChar)))) {
                            return false;
                        }
                        exponentUsed = true;
                    }
                    case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> digitsCount++;
                    default -> {
                        return false;
                    }
                }
                prevChar = aChar;
            }

            if (prevChar.equals('e') || prevChar.equals('E') || prevChar.equals('-') || prevChar.equals('+')) {
                return false;
            }

            if (dotUsed && digitsCount == 0) {
                return false;
            }

            return true;
        }
    }

    public static class Simplified {

        public boolean isNumber(String s) {
            boolean decimalPointSeen = false;
            boolean eSeen = false;
            boolean digitSeen = false;

            for (int i = 0; i < s.length(); i++) {
                char aChar = s.charAt(i);
                if (Character.isDigit(aChar)) {
                    digitSeen = true;
                } else if (aChar == '.') {
                    if (eSeen || decimalPointSeen) {
                        return false;
                    }
                    decimalPointSeen = true;
                } else if (aChar == 'e' || aChar == 'E') {
                    if (eSeen || !digitSeen) {
                        return false;
                    }
                    digitSeen = false;
                    eSeen = true;
                } else if (aChar == '+' || aChar == '-') {
                    if (i > 0 && (s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            return digitSeen;
        }
    }

}
