import kotlin.math.PI
import kotlin.test.*

class EllipseTest {

    @Test
    fun testGetArea() {
        val p = Point(0.0, 0.0)
        val r1 = 2.0
        val r2 = 3.0
        val ellipse = Ellipse(p, r1, r2)

        val expectedArea = PI * r1 * r2
        assertEquals(expectedArea, ellipse.getArea())
    }

    @Test
    fun testAreaNotZero() {
        val p = Point(0.0, 0.0)
        val r1 = 0.0
        val r2 = 3.0

        val exception = assertFailsWith<IllegalArgumentException> {
            Ellipse(p, r1, r2)
        }

        assertTrue(exception.message!!.contains("greater than zero"))
    }

    @Test
    fun testGetAttributes() {
        val p = Point(1.0, 2.0)
        val r1 = 5.0
        val r2 = 6.0
        val ellipse = Ellipse(p, r1, r2)

        val attributes = ellipse.getAttributes()
        assertTrue(attributes is ShapeAttributes.PointAndTwoDoubles)

        val returnedP = attributes.point

        // Same coordinate values
        assertEquals(p.getX(), returnedP.getX())
        assertEquals(p.getY(), returnedP.getY())

        // Not same reference
        assertNotSame(p, returnedP)

        // Correct radii
        assertEquals(r1, attributes.radius1)
        assertEquals(r2, attributes.radius2)
    }

    @Test
    fun testMove() {
        val p = Point(1.0, 1.0)
        val ellipse = Ellipse(p, 2.0, 2.0)

        ellipse.move(2.0, -1.0)

        assertEquals(3.0, p.getX())
        assertEquals(0.0, p.getY())
    }
}