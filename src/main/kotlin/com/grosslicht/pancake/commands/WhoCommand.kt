package com.grosslicht.pancake.commands

import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import java.security.SecureRandom

/**
 * Created by patrickgrosslicht on 19/03/17.
 */
class WhoCommand : BaseCommand() {
    override val moduleName = "who"
    val random = SecureRandom()
    override fun onNext(t: MessageReceivedEvent) {
        if (t.author.isBot) return
        if (t.message.strippedContent.contains("!who")) {
            val members = t.guild.members
            val rand = random.nextInt(members.count())
            val member = members[rand].effectiveName
            t.textChannel.sendMessage(t.message.content.replace("!who", member)).queue()
        }
    }
}