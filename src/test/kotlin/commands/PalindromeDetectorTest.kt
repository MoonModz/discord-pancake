package com.grosslicht.pancake.commands

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PalindromeDetectorTest {
    @Test
    fun testNormalizeSentence() {
        val palindromeDetector = PalindromeDetector()
        val string = palindromeDetector.normalizeSentence("a man a plan a canal panama")
        assertEquals(string, "a man a plan a canal panama")
    }

    @Test
    fun testNormalizeSentence1() {
        val palindromeDetector = PalindromeDetector()
        val string = palindromeDetector.normalizeSentence("A man, a plan, a canal; Panama.")
        assertEquals(string, "a man a plan a canal panama")
    }

    @Test
    fun testNormalizeSentence2() {
        val palindromeDetector = PalindromeDetector()
        val string = palindromeDetector.normalizeSentence("Eine güldne, gute Tugend: Lüge nie!")
        assertEquals(string, "eine güldne gute tugend lüge nie")
    }

    @Test
    fun palindromeSentence() {
        val palindromeDetector = PalindromeDetector()
        val string = palindromeDetector.normalizeSentence("a man a plan a canal panama")
        assertTrue(palindromeDetector.isSentencePalindrom(string))
    }

    @Test
    fun palindromeSentence2() {
        val palindromeDetector = PalindromeDetector()
        val string = palindromeDetector.normalizeSentence("Die Liebe ist Sieger; stets rege ist sie bei Leid.")
        assertTrue(palindromeDetector.isSentencePalindrom(string))
    }

    @Test
    fun palindromeSentence3() {
        val palindromeDetector = PalindromeDetector()
        val string = palindromeDetector.normalizeSentence("Eine güldne, gute Tugend: Lüge nie!")
        assertTrue(palindromeDetector.isSentencePalindrom(string))
    }

    @Test
    fun palindromeSentence4() {
        val palindromeDetector = PalindromeDetector()
        val string = palindromeDetector.normalizeSentence("Trug Tim eine so helle Hose nie mit Gurt?")
        assertTrue(palindromeDetector.isSentencePalindrom(string))
    }

    @Test
    fun palindromeSentence5() {
        val palindromeDetector = PalindromeDetector()
        val string = palindromeDetector.normalizeSentence("A man, a plan, a canal; Panama.")
        assertTrue(palindromeDetector.isSentencePalindrom(string))
    }

    @Test
    fun palindromeSentence6() {
        val palindromeDetector = PalindromeDetector()
        val string = palindromeDetector.normalizeSentence("This is not a palindrome")
        assertFalse(palindromeDetector.isSentencePalindrom(string))
    }

    @Test
    fun palindromeSentence7() {
        val palindromeDetector = PalindromeDetector()
        val string = palindromeDetector.normalizeSentence("Eine göldne, gute Tugend: Lüge nie!")
        assertFalse(palindromeDetector.isSentencePalindrom(string))
    }
}