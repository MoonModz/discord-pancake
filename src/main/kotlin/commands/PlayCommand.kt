package com.grosslicht.pancake.commands

import net.dv8tion.jda.core.entities.Game
import net.dv8tion.jda.core.events.message.MessageReceivedEvent

class PlayCommand : BaseCommand() {
    override val moduleName = "play"
    override fun onNext(t: MessageReceivedEvent) {
        if (t.author.isBot) return
        if (t.message.contentStripped.startsWith("!play")) {
            t.jda.presence.game = Game.of(Game.GameType.DEFAULT, t.message.contentStripped.removePrefix("!play "))
            t.textChannel.sendMessage("Sounds like fun. Maybe.").queue()
        }
    }
}
