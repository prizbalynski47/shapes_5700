package Instructions

import Computer
import JumpByteManager

class JumpInstruction(computer: Computer) : InstructionTemplate(computer) {
    override fun splitBytes(byte1: Int, byte2: Int): List<Int> {
        return JumpByteManager().splitBytes(byte1, byte2)
    }

    override fun performOperation(operands: List<Int>) {
        computer.setP(operands[1])
    }

    override fun incrementProgramCounter() {
        //noop
    }
}