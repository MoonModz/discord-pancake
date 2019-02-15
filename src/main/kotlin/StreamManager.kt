package com.grosslicht.pancake

import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject
import net.dv8tion.jda.core.events.message.MessageReceivedEvent

object StreamManager {
    val disposables: HashMap<String, Disposable> by lazy { HashMap<String, Disposable>() }
    val messages: PublishSubject<MessageReceivedEvent> by lazy { PublishSubject.create<MessageReceivedEvent>() }
}