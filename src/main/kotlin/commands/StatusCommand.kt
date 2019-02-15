package com.grosslicht.pancake.commands

import com.grosslicht.pancake.StreamManager
import net.dv8tion.jda.core.events.message.MessageReceivedEvent

class StatusCommand : BaseCommand() {
    override val moduleName = "status"
    override fun onNext(t: MessageReceivedEvent) {
        if (t.author.id != "135726717363945472") return
        when {
            t.message.contentDisplay.startsWith("!disable ") -> disable(t.message.contentDisplay.removePrefix("!disable "))
            t.message.contentDisplay.startsWith("!enable ") -> enable(t.message.contentDisplay.removePrefix("!enable "))
            t.message.contentDisplay == "!list" -> t.channel.sendMessage(list()).queue()
        }
    }

    private fun disable(module: String) {
        StreamManager.disposables.remove(module)?.dispose()
    }

    private fun enable(module: String) {
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

    private fun list(): String {
        return StreamManager.disposables.map { it.key }.joinToString(", ")
    }
}