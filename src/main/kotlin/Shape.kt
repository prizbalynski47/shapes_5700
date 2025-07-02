abstract class Shape {
    abstract fun getAttributes(): ShapeAttributes
    abstract fun getArea(): Double
    abstract fun move(xOffset: Double, yOffset: Double)
}