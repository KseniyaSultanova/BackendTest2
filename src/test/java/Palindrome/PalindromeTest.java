package Palindrome;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class PalindromeTest {
    Palindrome palindrome = new Palindrome();

    @DisplayName("Слово является палиндромом")
    @ParameterizedTest
    @ValueSource(strings = {"123321, MOM"})
    public void TestIsPalindromeMethod(){
        Assertions.assertTrue(palindrome.isPalindrome("01233210"));
        Assertions.assertTrue(palindrome.isPalindrome("0123A210"));
    }


    @DisplayName("Слово является палиндромом")
    @ParameterizedTest
    @ValueSource(strings = { "racecar", "rAdar", "able was I ere I saw elba" })
    public void isPalindromeTest(String word){
        Assertions.assertTrue(palindrome.isPalindrome(word));
    }

}