class RAM {
    private val instructions: Array<Int> = Array<Int>(4000) {0}

    fun readByte(address: Int): Int {
        return instructions[address]
    }

    fun writeByte(address: Int, value: Int): Boolean {
        instructions[address] = value
        return true
    }
}