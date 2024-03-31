package org.example

fun main() {

    val semaphoreOperates = SemaphoreOperates()
    semaphoreOperates.start()
    Thread.sleep(30000)
    semaphoreOperates.stop()
}