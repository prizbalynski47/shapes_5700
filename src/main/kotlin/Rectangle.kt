open class Rectangle(
    private val point1: Point,
    private val point2: Point
) : Shape() {
    private val area: Double =
        (point1.getX() - point2.getX()) * (point1.getY() - point2.getY()).let {if (it < 0) -it else it}

    init {
        require(area > 0) {
            "Rectangle area must be greater than zero, got: $area"
        }
    }

    override fun getAttributes(): ShapeAttributes.TwoPoints {
        return ShapeAttributes.TwoPoints(point1.clone(), point2.clone())
    }

    override fun move(xOffset: Double, yOffset: Double) {
        point1.move(xOffset, yOffset)
        point2.move(xOffset, yOffset)
    }

    override fun getArea(): Double {
        return (area)
    }
}