package Instructions

import Computer
import SplitFirstByteManager

class StoreInstruction(computer: Computer) : InstructionTemplate(computer) {
    override fun splitBytes(byte1: Int, byte2: Int): List<Int> {
        return SplitFirstByteManager().splitBytes(byte1, byte2)
    }

    override fun performOperation(operands: List<Int>) {
        val register = operands[1]
        val value = operands[2]
        computer.setRegister(register, value)
    }
}