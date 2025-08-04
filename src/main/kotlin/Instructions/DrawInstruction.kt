package Instructions

import Computer
import SplitBothByteManager

class DrawInstruction(computer: Computer) : InstructionTemplate(computer) {
    override fun splitBytes(byte1: Int, byte2: Int): List<Int> {
        return SplitBothByteManager().splitBytes(byte1, byte2)
    }

    override fun performOperation(operands: List<Int>) {
        val character = computer.getRegister(operands[1])
        val row = operands[2]
        val col = operands[3]
        computer.printToScreen(character, row, col)
    }
}