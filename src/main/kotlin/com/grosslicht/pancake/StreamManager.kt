package com.grosslicht.pancake

import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject
import net.dv8tion.jda.core.events.message.MessageReceivedEvent
import java.util.*

/**
 * Created by patrickgrosslicht on 19/03/17.
 */
object StreamManager {
    val disposables: HashMap<String, Disposable> by lazy { HashMap<String, Disposable>() }
    val messages: PublishSubject<MessageReceivedEvent> by lazy<PublishSubject<MessageReceivedEvent>> { PublishSubject.create() }
}