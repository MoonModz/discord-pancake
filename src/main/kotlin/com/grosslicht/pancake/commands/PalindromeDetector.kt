package com.grosslicht.pancake.commands

import net.dv8tion.jda.core.events.message.MessageReceivedEvent

/**
 * Created by patrickgrosslicht on 19/03/17.
 */
class PalindromeDetector : BaseCommand() {
    override val moduleName = "palindrome"
    val sentencePalindromeEmoji: String = "🔁"
    val wordPalindromeEmoji: String = "🔄"
    override fun onNext(t: MessageReceivedEvent) {
        if (t.message.strippedContent.length < 4 || t.message.author.isBot) return
        val normalizedMessage = t.message.strippedContent.replace(Regex("[^a-zA-Z ]"), "").toLowerCase()
        if (isPalindrome(normalizedMessage)) {
            t.message.addReaction(sentencePalindromeEmoji).queue()
            return
        }
        if (normalizedMessage.split(Regex("\\s+")).any { isPalindrome(it) }) {
            t.message.addReaction(wordPalindromeEmoji).queue()
        }
    }

    fun isPalindrome(word: String): Boolean {
        if (word.isBlank() || word.length < 4) return false
        val n = word.length
        return (0..(n/2)).none { word[it] != word[n - it - 1] }
    }
}