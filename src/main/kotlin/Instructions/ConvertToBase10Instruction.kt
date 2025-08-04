package Instructions

import Computer
import SplitFirstByteManager

class ConvertToBase10Instruction(computer: Computer) : InstructionTemplate(computer) {
    override fun splitBytes(byte1: Int, byte2: Int): List<Int> {
        return SplitFirstByteManager().splitBytes(byte1, byte2)
    }

    override fun performOperation(operands: List<Int>) {
        val byte = computer.getRegister(operands[1])
        val hundreds = byte / 100
        val tens = (byte % 100) / 10
        val ones = byte % 10
        computer.writeByte(computer.getA(), hundreds)
        computer.writeByte(computer.getA() + 1, tens)
        computer.writeByte(computer.getA() + 2, ones)
    }
}