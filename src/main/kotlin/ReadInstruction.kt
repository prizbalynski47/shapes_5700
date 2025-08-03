class ReadInstruction(computer: Computer) : InstructionTemplate(computer) {
    override fun splitBytes(byte1: Int, byte2: Int): List<Int> {
        return SplitFirstByteManager().splitBytes(byte1, byte2)
    }

    override fun performOperation(operands: List<Int>) {
        val register = operands[1]
        val address = computer.cpu.getA()
        if(computer.cpu.getM()) {
            computer.cpu.setRegister(register, computer.rom.readByte(address))
        } else {
            computer.cpu.setRegister(register, computer.ram.readByte(address))
        }
    }
}