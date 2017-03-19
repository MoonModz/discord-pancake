package com.grosslicht.pancake.commands

import com.grosslicht.pancake.StreamManager
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import mu.KLogging
import net.dv8tion.jda.core.events.message.MessageReceivedEvent

/**
 * Created by patrickgrosslicht on 19/03/17.
 */
abstract class BaseCommand : Observer<MessageReceivedEvent> {
    companion object : KLogging()
    open val moduleName: String = "default"

    override fun onComplete() {
        logger.info { "onComplete" }
    }

    override fun onError(e: Throwable) {
        logger.error { e }
    }

    override fun onSubscribe(d: Disposable) {
        StreamManager.disposables.put(moduleName, d)
        logger.info { moduleName }
        logger.info { d }
    }
}