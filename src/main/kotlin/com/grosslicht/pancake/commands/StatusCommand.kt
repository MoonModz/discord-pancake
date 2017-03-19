package com.grosslicht.pancake.commands

import com.grosslicht.pancake.StreamManager
import net.dv8tion.jda.core.events.message.MessageReceivedEvent

/**
 * Created by patrickgrosslicht on 19/03/17.
 */
class StatusCommand : BaseCommand() {
    override fun onNext(t: MessageReceivedEvent) {
        if (t.author.id != "135726717363945472") return
        when {
            t.message.content.startsWith("!disable ") -> disable(t.message.content.removePrefix("!disable "))
            t.message.content.startsWith("!enable ") -> enable(t.message.content.removePrefix("!enable "))
            t.message.content == "!list" -> t.channel.sendMessage(list()).queue()
        }
    }

    fun disable(module: String) {
        StreamManager.disposables.remove(module)?.dispose()
    }

    fun enable(module: String) {
        when (module) {
            "beep" -> StreamManager.messages.subscribe(BeepCommand())
            "commands" -> StreamManager.messages.subscribe(CommandsCommand())
            "friendship" -> StreamManager.messages.subscribe(FriendshipCommand())
            "modules" -> StreamManager.messages.subscribe(ModulesCommand())
            "play" -> StreamManager.messages.subscribe(PlayCommand())
            "who" -> StreamManager.messages.subscribe(WhoCommand())
            "yesorno" -> StreamManager.messages.subscribe(YesOrNoCommand())
            "palindrome" -> StreamManager.messages.subscribe(PalindromeDetector())
        }
    }

    fun list(): String {
        return StreamManager.disposables.map { it.key }.joinToString(", ")
    }
}