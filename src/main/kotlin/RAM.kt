class RAM {
    private val memoryArray: Array<Int> = Array<Int>(4000) {0}

    fun readByte(address: Int): Int {
        return memoryArray[address]
    }

    fun writeByte(address: Int, value: Int){
        memoryArray[address] = value
    }
}