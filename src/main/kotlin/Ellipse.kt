import kotlin.math.PI

open class Ellipse(
    private val point: Point,
    private val radius1: Double,
    private val radius2: Double
) : Shape() {
    private val area: Double = PI * radius1 * radius2

    init {
        require(area > 0) {
            "Ellipse area must be greater than zero, got: $area"
        }
    }

    override fun getAttributes(): ShapeAttributes.PointAndTwoDoubles {
        return ShapeAttributes.PointAndTwoDoubles(point.clone(), radius1, radius2)
    }

    override fun move(xOffset: Double, yOffset: Double) {
        point.move(xOffset, yOffset)
    }

    override fun getArea(): Double {
        return (area)
    }
}