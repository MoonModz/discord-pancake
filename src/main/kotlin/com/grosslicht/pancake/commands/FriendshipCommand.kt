package com.grosslicht.pancake.commands

import net.dv8tion.jda.core.events.message.MessageReceivedEvent

/**
 * Created by patrickgrosslicht on 19/03/17.
 */
class FriendshipCommand : BaseCommand() {
    override fun onNext(t: MessageReceivedEvent) {
        if (t.author.isBot) {
            return
        }
        if (t.message.strippedContent == "!friendship") {
            t.textChannel.sendMessage("Did anypony say magic?").queue()
        }
    }
}