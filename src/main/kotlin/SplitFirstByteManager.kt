class SplitFirstByteManager: ByteManager() {
    override fun splitBytes(byte1: Int, byte2: Int): List<Int> {
        return splitByte(byte1) + byte2
    }
}