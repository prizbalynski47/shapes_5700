package Instructions

import Computer
import SplitFirstByteManager

class ReadKeyboardInstruction(computer: Computer) : InstructionTemplate(computer) {
    override fun splitBytes(byte1: Int, byte2: Int): List<Int> {
        return SplitFirstByteManager().splitBytes(byte1, byte2)
    }

    override fun performOperation(operands: List<Int>) {
        computer.pause()
        println("Waiting for keyboard input")
        val input = readLine()
        val inputHex = parseHexString(input)
        computer.setRegister(operands[1], inputHex)
        computer.resume()
    }

    fun parseHexString(hex: String?): Int {
        if (hex == null) error("Hex string cannot be empty")
        else if (hex.length == 1) {
            return hex[0].digitToInt(16)
        }
        return hex.substring(0,2).toInt(16)
    }
}