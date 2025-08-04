package Instructions

import Computer

class SwitchMemoryInstruction(computer: Computer) : InstructionTemplate(computer)  {
    override fun splitBytes(byte1: Int, byte2: Int): List<Int> {
        return emptyList()
    }

    override fun performOperation(operands: List<Int>) {
        computer.toggleM()
    }
}