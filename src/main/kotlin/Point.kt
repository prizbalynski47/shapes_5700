class Point (
    val x: Double,
    val y: Double
) {

    fun getX() {
        return x
    }

    fun getY() {
        return y
    }

    fun clone() {
        return Point(x, y)
    }

    fun Move(xOffset: Double, yOffset: Double) {
        x = x + xOffset
        y = y + yOffset
    }
}