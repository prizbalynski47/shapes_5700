class WriteInstruction(computer: Computer) : InstructionTemplate(computer) {
    override fun splitBytes(byte1: Int, byte2: Int): List<Int> {
        return SplitFirstByteManager().splitBytes(byte1, byte2)
    }

    override fun performOperation(operands: List<Int>) {
        val value = computer.cpu.getRegister(operands[1])
        val address = computer.cpu.getA()
        if(computer.cpu.getM()) {
            computer.rom.writeByte(address, value)
        } else {
            computer.ram.writeByte(address, value)
        }
    }
}