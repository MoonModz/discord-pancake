package com.grosslicht.pancake

import io.reactivex.subjects.PublishSubject
import net.dv8tion.jda.core.events.message.MessageReceivedEvent

/**
 * Created by patrickgrosslicht on 19/03/17.
 */
object StreamManager {
    val messages: PublishSubject<MessageReceivedEvent> by lazy<PublishSubject<MessageReceivedEvent>> { PublishSubject.create() }
}