package com.grosslicht.pancake.commands

import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import java.security.SecureRandom

class YesOrNoCommand : BaseCommand() {
    override val moduleName = "yesorno"
    private val random = SecureRandom()
    private val thumbsUp: String = "👍"
    private val thumbsDown: String = "👎"
    override fun onNext(t: MessageReceivedEvent) {
        if (t.author.isBot) return
        if (t.message.contentStripped.contains("!yesorno")) {
            t.textChannel.sendMessage(if (random.nextBoolean()) "Yes." else "No.").queue()
            return
        }
        if (t.message.contentStripped.contains("!updown")) {
            t.message.addReaction(if (random.nextBoolean()) thumbsUp else thumbsDown).queue()
            return
        }
    }
}
