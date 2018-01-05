package com.grosslicht.pancake.commands

import net.dv8tion.jda.core.events.message.MessageReceivedEvent

/**
 * Created by patrickgrosslicht on 19/03/17.
 */
class BeepCommand : BaseCommand() {
    override val moduleName = "beep"
    override fun onNext(t: MessageReceivedEvent) {
        if (t.author.isBot) return
        if (t.message.contentStripped == "!beep") {
            t.textChannel.sendMessage("boop").queue()
        }
    }
}