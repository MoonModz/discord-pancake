package com.grosslicht.pancake.commands

import net.dv8tion.jda.core.events.message.MessageReceivedEvent

class FriendshipCommand : BaseCommand() {
    override val moduleName = "friendship"
    override fun onNext(t: MessageReceivedEvent) {
        if (t.author.isBot) return
        if (t.message.contentStripped == "!friendship") {
            t.textChannel.sendMessage("Did anypony say magic?").queue()
        }
    }
}