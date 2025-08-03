import java.util.concurrent.Executors
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

class InstructionHandler(
    private val executeInstruction: () -> Unit
) {
    private val executor = Executors.newSingleThreadScheduledExecutor()
    private var executionFuture: ScheduledFuture<*>? = null
    private var paused: Boolean = false

    private val instructionRunner = Runnable {
        try {
            if (!paused) {
                executeInstruction()
            }
        } catch (e: Exception) {
            println("Execution error: ${e.message}")
            stopExecution()
        }
    }

    fun startExecution() {
        if (executionFuture == null || executionFuture?.isCancelled == true) {
            executionFuture = executor.scheduleAtFixedRate(
                instructionRunner,
                0,
                1000L / 500L,
                TimeUnit.MILLISECONDS
            )
        }
    }

    fun stopExecution() {
        executionFuture?.cancel(true)
        executionFuture = null
    }

    fun shutdown() {
        stopExecution()
        executor.shutdown()
    }

    fun pause() {
        paused = true
    }

    fun resume() {
        paused = false
    }
}