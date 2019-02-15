package com.grosslicht.pancake

import com.grosslicht.pancake.commands.BeepCommand
import com.grosslicht.pancake.commands.CommandsCommand
import com.grosslicht.pancake.commands.FriendshipCommand
import com.grosslicht.pancake.commands.ModulesCommand
import com.grosslicht.pancake.commands.PalindromeDetector
import com.grosslicht.pancake.commands.PlayCommand
import com.grosslicht.pancake.commands.RxConverter
import com.grosslicht.pancake.commands.StatusCommand
import com.grosslicht.pancake.commands.WhoCommand
import com.grosslicht.pancake.commands.YesOrNoCommand
import net.dv8tion.jda.core.AccountType
import net.dv8tion.jda.core.JDABuilder

fun main(args: Array<String>) {
    val builder = JDABuilder(AccountType.BOT)
    val token = System.getenv("DISCORD_API_TOKEN")
    builder.setToken(token)
    builder.addEventListener(RxConverter())
    StreamManager.messages.subscribe(BeepCommand())
    StreamManager.messages.subscribe(CommandsCommand())
    StreamManager.messages.subscribe(FriendshipCommand())
    StreamManager.messages.subscribe(ModulesCommand())
    StreamManager.messages.subscribe(PlayCommand())
    StreamManager.messages.subscribe(WhoCommand())
    StreamManager.messages.subscribe(YesOrNoCommand())
    StreamManager.messages.subscribe(StatusCommand())
    val shouldCheckPalindromes = System.getenv("CHECK_PALINDROME").toBoolean()
    if (shouldCheckPalindromes) StreamManager.messages.subscribe(PalindromeDetector())
    val jda = builder.build().awaitReady()
}
