package Instructions

import Computer
import SetTByteManager

class SetTInstruction(computer: Computer) : InstructionTemplate(computer)  {
    override fun splitBytes(byte1: Int, byte2: Int): List<Int> {
        return SetTByteManager().splitBytes(byte1, byte2)
    }

    override fun performOperation(operands: List<Int>) {
        computer.setT(operands[1])
    }
}