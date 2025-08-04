package Instructions

import Computer
import SplitBothByteManager

class ConvertByteToAsciiInstruction(computer: Computer) : InstructionTemplate(computer) {
    override fun splitBytes(byte1: Int, byte2: Int): List<Int> {
        return SplitBothByteManager().splitBytes(byte1, byte2)
    }

    override fun performOperation(operands: List<Int>) {
        val digit = computer.getRegister(operands[1])
        if (digit > 0xF) {
            error("Register value too large")
        }
        val register = operands[2]
        val hexChar = if (digit < 10) {
            '0' + digit
        } else {
            'A' + digit - 10
        }
        computer.setRegister(register, hexChar.code)
    }
}