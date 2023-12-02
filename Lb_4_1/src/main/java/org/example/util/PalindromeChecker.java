package org.example.util;

public class PalindromeChecker {
    public static boolean isPalindrome(String word) {
        if (word == null) {
            return false;
        }
        int i = 0, j = word.length() - 1;

        while (i < j) {
            if (word.charAt(i) != word.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}