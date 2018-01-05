package com.grosslicht.pancake.commands

import net.dv8tion.jda.core.entities.Game
import net.dv8tion.jda.core.events.message.MessageReceivedEvent

/**
 * Created by patrickgrosslicht on 19/03/17.
 */
class PlayCommand : BaseCommand() {
    override val moduleName = "play"
    override fun onNext(t: MessageReceivedEvent) {
        if (t.author.isBot) return
        if (t.message.contentStripped.startsWith("!play")) {
            t.jda.presence.game = Game.of(t.message.contentStripped.removePrefix("!play "))
            t.textChannel.sendMessage("Sounds like fun. Maybe.").queue()
        }
    }
}
