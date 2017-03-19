package com.grosslicht.pancake.commands

import net.dv8tion.jda.core.events.message.MessageReceivedEvent

/**
 * Created by patrickgrosslicht on 19/03/17.
 */
class CommandsCommand : BaseCommand() {
    val commandsText = """
        |help:    Gets description of given command.
        |commands:    Lists all available commands.
        |modules:    Lists all installed modules.
        |play:    Sets playing status.
        |restart:    Reloads the modules and relogs the bot.
        |beep:    You beep, I boop.
        |friendship:    Friendship is magic.
        |scan:    Scans a channel and generates wordpairs.
        |who:    Picks a random person, emulating the Roll Bot from Kik.
        |yesorno:    Chooses yes or no, primitive version of Magic Eight Bot from Kik.
        """.trimMargin()

    override fun onNext(t: MessageReceivedEvent) {
        if (t.author.isBot) {
            return
        }
        if (t.message.strippedContent == "!commands") {
            t.textChannel.sendMessage(commandsText).queue()
        }
    }
}
