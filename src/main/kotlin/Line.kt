import kotlin.math.sqrt

class Line(
    private val point1: Point,
    private val point2: Point
) : Shape() {
    override fun getAttributes(): ShapeAttributes.TwoPoints {
        return ShapeAttributes.TwoPoints(point1.clone(), point2.clone())
    }

    fun slope(): Double {
        return (point1.getY() - point2.getY()) / (point1.getX() - point2.getX())
    }

    fun length(): Double {
        return (sqrt((point1.getX() - point2.getX()) * (point1.getX() - point2.getX()) +
                (point1.getY() - point2.getY()) * (point1.getY() - point2.getY())))
    }

    override fun move(xOffset: Double, yOffset: Double) {
        point1.move(xOffset, yOffset)
        point2.move(xOffset, yOffset)
    }

    override fun getArea(): Double {
        throw NotImplementedError("Not used in Line")
    }
}