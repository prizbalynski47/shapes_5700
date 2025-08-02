class StoreInstruction(cpu: CPU) : InstructionTemplate(cpu) {
    override fun splitBytes(byte1: Int, byte2: Int): List<Int> {
        return SplitFirstByteManager().splitBytes(byte1, byte2)
    }

    override fun performOperation(operands: List<Int>) {
        val register = operands[1]
        val value = operands[2]
        cpu.setRegister(register, value)
    }
}