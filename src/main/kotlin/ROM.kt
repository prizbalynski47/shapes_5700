class ROM {
    private val instructions: Array<Int> = Array<Int>(4000) {0}

    fun readByte(address: Int): Int {
        return instructions[address]
    }

    fun writeByte(address: Int, value: Int){
        error("ROM chips do not currently support write instructions")
    }

    fun loadFromBytes(bytes: ByteArray) {
        val length = minOf(bytes.size, instructions.size)
        for (i in 0 until length) {
            instructions[i] = bytes[i].toInt() and 0xFF // Convert to unsigned Int
        }
    }
}