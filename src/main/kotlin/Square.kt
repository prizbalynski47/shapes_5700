class Square(
    point1: Point,
    point2: Point
) : Rectangle(point1, point2) {

    init {
        val width = (point1.getX() - point2.getX()).let { if (it < 0) -it else it }
        val height = (point1.getY() - point2.getY()).let { if (it < 0) -it else it }
        require(width == height) {
            "Square must have equal width and height, got: width=$width, height=$height"
        }
    }
}