class SetTByteManager: ByteManager() {
    override fun splitBytes(byte1: Int, byte2: Int): List<Int> {
        val operation = byte1 shr 4
        val newTimeFirstNibble = byte1 and 0x0f
        val newTime = (newTimeFirstNibble shl 4) or (byte2 shr 4)
        return listOf(operation, newTime)
    }
}