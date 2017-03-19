package com.grosslicht.pancake.commands

import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import java.security.SecureRandom

/**
 * Created by patrickgrosslicht on 19/03/17.
 */
class YesOrNoCommand : BaseCommand() {
    val random = SecureRandom()
    override fun onNext(t: MessageReceivedEvent) {
        if (t.author.isBot) {
            return
        }
        if (t.message.strippedContent.contains("!yesorno")) {
            t.textChannel.sendMessage(if (random.nextBoolean()) "Yes." else "No.").queue()
        }
    }
}
