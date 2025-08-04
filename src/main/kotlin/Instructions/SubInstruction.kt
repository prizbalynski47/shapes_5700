package Instructions

import Computer
import SplitBothByteManager

class SubInstruction(computer: Computer) : InstructionTemplate(computer) {
    override fun splitBytes(byte1: Int, byte2: Int): List<Int> {
        return SplitBothByteManager().splitBytes(byte1, byte2)
    }

    override fun performOperation(operands: List<Int>) {
        val register1 = operands[1]
        val register2 = operands[2]
        val register3 = operands[3]
        val diff = computer.getRegister(register1) - computer.getRegister(register2)
        val maskedDiff = diff and 0xFF
        computer.setRegister(register3, maskedDiff)
    }
}