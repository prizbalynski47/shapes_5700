class Screen {
    private val screenRam: Array<Char> = Array<Char>(64) {'0'}
    private val numCols: Int = 8
    private val numRows: Int = 8

    fun setChar(value: Int, row: Int, col: Int) {
        if (value > 0x7F) {
            error("Value out of range for ASCII")
        }
        screenRam[(row * numCols) + col] = value.toChar()
    }

    fun printScreen() {
        var outString: String = ""
        for (row in 0 until numRows) {
            for (col in 0 until numCols) {
                outString += screenRam[(row * numCols) + col] + " "
            }
            outString += "\n"
        }
        print(outString)
    }
}