sealed class ShapeAttributes {
    data class TwoPoints(val point1: Point, val point2: Point) : ShapeAttributes()
    data class PointAndTwoDoubles(val point: Point, val radius1: Double, val radius2: Double) : ShapeAttributes()
    data class ThreePoints(val point1: Point, val point2: Point, val point3: Point) : ShapeAttributes()
}