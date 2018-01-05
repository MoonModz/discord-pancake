package com.grosslicht.pancake.commands

import com.grosslicht.pancake.StreamManager
import mu.KLogging
import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import net.dv8tion.jda.core.hooks.ListenerAdapter


/**
 * Created by patrickgrosslicht on 19/03/17.
 */

class RxConverter : ListenerAdapter() {
    companion object : KLogging()
    override fun onMessageReceived(event: MessageReceivedEvent) {
        logger.debug { event.message.contentDisplay }
        StreamManager.messages.onNext(event)
    }
}
