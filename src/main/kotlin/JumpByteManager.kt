class JumpByteManager: ByteManager() {
    override fun splitBytes(byte1: Int, byte2: Int): List<Int> {
        val operation = byte1 shr 4
        val addressFirstNibble = byte1 and 0x0f
        val address = (addressFirstNibble shl 8) or byte2
        return listOf(operation, address)
    }
}