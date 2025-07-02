class Circle(
    point: Point,
    radius1: Double,
    radius2: Double
) : Ellipse(point, radius1, radius2) {

    init {
        require(radius1 == radius2) {
            "Square must have two equal radii, got: radius 1=$radius1, radius 2=$radius2"
        }
    }
}