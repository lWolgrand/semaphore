package org.example
import org.example.enum.SemaphoreColor
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

class Semaphore(private var name: String) {
    private lateinit var current: SemaphoreColor
    private var running: Boolean = false
    private fun changeColor(color: SemaphoreColor)
    {
        current = color
        println("$name changed to $current")
    }

    fun start(config: Map<SemaphoreColor, Int>) {
        running = true
        current = config.entries.first().key
        thread {
            while (running) {
                for ((state, duration) in config) {
                    changeColor(state)
                    TimeUnit.SECONDS.sleep((duration * 1).toLong())
                }
            }
        }
    }

    fun stop()
    {
        this.running = false
    }

}