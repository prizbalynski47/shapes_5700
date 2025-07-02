open class Triangle(
    private val point1: Point,
    private val point2: Point,
    private val point3: Point
) : Shape() {
    private val x1 = point1.getX()
    private val x2 = point2.getX()
    private val x3 = point3.getX()
    private val y1 = point1.getY()
    private val y2 = point2.getY()
    private val y3 = point3.getY()

    private val area: Double =
        (0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2))).let {if (it < 0) -it else it}

    init {
        require(area > 0) {
            "Rectangle area must be greater than zero, got: $area"
        }
    }

    override fun getAttributes(): ShapeAttributes.ThreePoints {
        return ShapeAttributes.ThreePoints(point1.clone(), point2.clone(), point3.clone())
    }

    override fun move(xOffset: Double, yOffset: Double) {
        point1.move(xOffset, yOffset)
        point2.move(xOffset, yOffset)
        point3.move(xOffset, yOffset)
    }

    override fun getArea(): Double {
        return (area)
    }
}