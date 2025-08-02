class SplitBothByteManager: ByteManager() {
    override fun splitBytes(byte1: Int, byte2: Int): List<Int> {
        return splitByte(byte1) + splitByte(byte2)
    }
}