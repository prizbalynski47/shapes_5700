abstract class InstructionTemplate(
    val computer: Computer
) {
    fun execute(byte1: Int, byte2: Int) {
        val operands = splitBytes(byte1, byte2)
        performOperation(operands)
        incrementProgramCounter()
    }

    protected abstract fun splitBytes(byte1: Int, byte2: Int): List<Int>
    protected abstract fun performOperation(operands: List<Int>)
    protected open fun incrementProgramCounter() {
        computer.cpu.incrementP()
    }
}