package org.example.util;
import org.junit.Test;
import static org.junit.Assert.*;

public class PalindromeCheckerTest {
    @Test
    public void testIsPalindrome() {
        assertTrue(PalindromeChecker.isPalindrome("madam"));
        assertTrue(PalindromeChecker.isPalindrome("racecar"));
        assertTrue(PalindromeChecker.isPalindrome("a"));
        assertTrue(PalindromeChecker.isPalindrome(""));

        assertFalse(PalindromeChecker.isPalindrome("hello"));
        assertFalse(PalindromeChecker.isPalindrome("world"));
    }
}