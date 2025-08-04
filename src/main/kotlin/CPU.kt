import java.util.concurrent.Executors
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

class CPU {
    private val registers: Array<Int> = Array<Int>(8) {0}
    private var P: Int = 0
    @Volatile private var T: Int = 0
    private var A: Int = 0
    private var M: Boolean = false

    private val timerExecutor = Executors.newSingleThreadScheduledExecutor()
    private var timerFuture: ScheduledFuture<*>? = null

    fun setRegister(register: Int, value: Int) {
        registers[register] = value
    }

    fun getRegister(register: Int): Int {
        return registers[register]
    }

    fun setP(address: Int) {
        if(address % 2 != 0) {
            error("Program counter must be set to an even address")
        }
        P = address
    }

    fun incrementP() {
        P += 2
    }

    fun getP(): Int {
        return P
    }

    fun setT(time: Int) {
        T = time
        restartTimerIfNeeded()
    }

    fun getT(): Int {
        return T
    }

    fun setA(address: Int) {
        A = address
    }

    fun getA(): Int {
        return A
    }

    fun toggleM() {
        M = !M
    }

    fun getM(): Boolean {
        return M
    }

    private fun restartTimerIfNeeded() {
        timerFuture?.cancel(true)
        timerFuture = null

        if (T > 0) {
            startTimer()
        }
    }

    private fun startTimer() {
        timerFuture = timerExecutor.scheduleAtFixedRate({
            synchronized(this) {
                if (T > 0) {
                    T--
                } else {
                    timerFuture?.cancel(true)
                    timerFuture = null
                }
            }
        }, 0, 1000L / 60L, TimeUnit.MILLISECONDS)
    }

    fun shutdownTimer() {
        timerExecutor.shutdown()
    }
}