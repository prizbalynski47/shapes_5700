abstract class ByteManager {
    protected fun splitByte(byte: Int): List<Int> {
        val nibble1 = byte shr 4
        val nibble2 = byte and 0x0f
        return listOf(nibble1, nibble2)
    }

    abstract fun splitBytes(byte1: Int, byte2: Int): List<Int>
}