package com.grosslicht.pancake.commands

import net.dv8tion.jda.core.events.message.MessageReceivedEvent

class ModulesCommand : BaseCommand() {
    override val moduleName = "modules"
    private val modulesText = """
        |Installed modules:
        |```
        |Markov
        |Kik Bots```
        """.trimMargin()

    override fun onNext(t: MessageReceivedEvent) {
        if (t.author.isBot) return
        if (t.message.contentStripped == "!modules") {
            t.textChannel.sendMessage(modulesText).queue()
        }
    }
}
