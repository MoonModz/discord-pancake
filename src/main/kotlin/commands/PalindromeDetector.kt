package com.grosslicht.pancake.commands

import net.dv8tion.jda.core.events.message.MessageReceivedEvent

class PalindromeDetector : BaseCommand() {
    override val moduleName = "palindrome"
    private val sentencePalindromeEmoji: String = "🔁"
    private val wordPalindromeEmoji: String = "🔄"
    override fun onNext(t: MessageReceivedEvent) {
        if (t.message.contentStripped.length < 4 || t.message.author.isBot) return
        val normalizedMessage = normalizeSentence(t.message.contentStripped)
        if (isSentencePalindrom(normalizedMessage)) {
            t.message.addReaction(sentencePalindromeEmoji).queue()
            return
        }
        if (normalizedMessage.split(Regex("\\s+")).any { isPalindrome(it) }) {
            t.message.addReaction(wordPalindromeEmoji).queue()
        }
    }

    fun isSentencePalindrom(sentence: String): Boolean {
        val trimmedSentence = sentence.replace(Regex("\\s+"), "")
        if (trimmedSentence.length < 4) return false
        return isPalindrome(trimmedSentence)
    }

    fun normalizeSentence(sentence: String): String {
        return sentence.replace(Regex("[^\\p{IsLatin}\\s]"), "").toLowerCase()
    }

    private fun isPalindrome(word: String): Boolean {
        if (word.isBlank() || word.length < 4) return false
        val n = word.length
        return (0..(n / 2)).none { word[it] != word[n - it - 1] }
    }
}