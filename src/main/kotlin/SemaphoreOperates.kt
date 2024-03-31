package org.example
import org.example.enum.SemaphoreColor
class SemaphoreOperates(
    private val main: Semaphore = Semaphore("Main"),
    private val cross: Semaphore = Semaphore("Cross")
)
{
    fun start() {
        println("initializing...")
        val mainConfig: Map<SemaphoreColor, Int> = mapOf(
            SemaphoreColor.GREEN to 5,
            SemaphoreColor.YELLOW to 3,
            SemaphoreColor.RED to 8
        )

        val crossConfig = mapOf(
            SemaphoreColor.RED to 8,
            SemaphoreColor.GREEN to 5,
            SemaphoreColor.YELLOW to 3
        )

        main.start(mainConfig)
        cross.start(crossConfig)
    }
    fun stop() {
        println("Stopping...")
        main.stop()
        cross.stop()

    }
}
