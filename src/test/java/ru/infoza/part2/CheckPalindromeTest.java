package ru.infoza.part2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static ru.infoza.part2.CheckPalindrome.isPalindrome;

public class CheckPalindromeTest {
    @Test
    public void checkPalindrome() {
        String palindrome = "Madam, I'm Adam!";
        Assertions.assertTrue(isPalindrome(palindrome));
    }

    @Test
    public void checkText() {
        String text = "I'm breaking my habits";
        Assertions.assertFalse(isPalindrome(text));
    }
}
