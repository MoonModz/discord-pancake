package com.grosslicht.pancake.commands

import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Created by patrickgrosslicht on 20/03/17.
 */
class PalindromeDetectorTest {
    lateinit var palindromeDetector: PalindromeDetector

    @Before
    fun setUp() {
        this.palindromeDetector = PalindromeDetector()
    }

    @Test
    fun testNormalizeSentence() {
        val string = palindromeDetector.normalizeSentence("a man a plan a canal panama")
        Assert.assertEquals(string, "a man a plan a canal panama")
    }

    @Test
    fun testNormalizeSentence1() {
        val string = palindromeDetector.normalizeSentence("A man, a plan, a canal; Panama.")
        Assert.assertEquals(string, "a man a plan a canal panama")
    }

    @Test
    fun testNormalizeSentence2() {
        val string = palindromeDetector.normalizeSentence("Eine güldne, gute Tugend: Lüge nie!")
        Assert.assertEquals(string, "eine güldne gute tugend lüge nie")
    }

    @Test
    fun palindromeSentence() {
        val string = palindromeDetector.normalizeSentence("a man a plan a canal panama")
        Assert.assertTrue(palindromeDetector.isSentencePalindrom(string))
    }

    @Test
    fun palindromeSentence2() {
        val string = palindromeDetector.normalizeSentence("Die Liebe ist Sieger; stets rege ist sie bei Leid.")
        Assert.assertTrue(palindromeDetector.isSentencePalindrom(string))
    }

    @Test
    fun palindromeSentence3() {
        val string = palindromeDetector.normalizeSentence("Eine güldne, gute Tugend: Lüge nie!")
        Assert.assertTrue(palindromeDetector.isSentencePalindrom(string))
    }

    @Test
    fun palindromeSentence4() {
        val string = palindromeDetector.normalizeSentence("Trug Tim eine so helle Hose nie mit Gurt?")
        Assert.assertTrue(palindromeDetector.isSentencePalindrom(string))
    }

    @Test
    fun palindromeSentence5() {
        val string = palindromeDetector.normalizeSentence("A man, a plan, a canal; Panama.")
        Assert.assertTrue(palindromeDetector.isSentencePalindrom(string))
    }

    @Test
    fun palindromeSentence6() {
        val string = palindromeDetector.normalizeSentence("This is not a palindrome")
        Assert.assertFalse(palindromeDetector.isSentencePalindrom(string))
    }

    @Test
    fun palindromeSentence7() {
        val string = palindromeDetector.normalizeSentence("Eine göldne, gute Tugend: Lüge nie!")
        Assert.assertFalse(palindromeDetector.isSentencePalindrom(string))
    }
}