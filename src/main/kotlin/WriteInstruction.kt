class WriteInstruction(computer: Computer) : InstructionTemplate(computer) {
    override fun splitBytes(byte1: Int, byte2: Int): List<Int> {
        return SplitFirstByteManager().splitBytes(byte1, byte2)
    }

    override fun performOperation(operands: List<Int>) {
        val value = computer.getRegister(operands[1])
        val address = computer.getA()
        computer.writeByte(address, value)
    }
}