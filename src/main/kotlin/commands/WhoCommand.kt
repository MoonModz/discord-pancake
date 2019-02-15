package com.grosslicht.pancake.commands

import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import java.security.SecureRandom

class WhoCommand : BaseCommand() {
    override val moduleName = "who"
    private val random = SecureRandom()
    override fun onNext(t: MessageReceivedEvent) {
        if (t.author.isBot) return
        if (t.message.contentStripped.contains("!who")) {
            val members = t.guild.members
            val rand = random.nextInt(members.count())
            val member = members[rand].effectiveName
            t.textChannel.sendMessage(t.message.contentDisplay.replace("!who", member)).queue()
        }
    }
}