package com.grosslicht.pancake.commands

import net.dv8tion.jda.core.events.message.MessageReceivedEvent

/**
 * Created by patrickgrosslicht on 19/03/17.
 */
class ModulesCommand : BaseCommand() {
    val modulesText = """
        |Installed modules:
        |```Markov
        |Kik Bots```
        """.trimMargin()

    override fun onNext(t: MessageReceivedEvent) {
        if (t.author.isBot) {
            return
        }
        if (t.message.strippedContent == "!modules") {
            t.textChannel.sendMessage(modulesText).queue()
        }
    }
}
