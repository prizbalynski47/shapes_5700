import kotlin.math.sqrt
import kotlin.test.*

class LineTest {

    @Test
    fun testGetAttributes() {
        val p1 = Point(0.0, 0.0)
        val p2 = Point(1.0, 1.0)
        val line = Line(p1, p2)

        val attributes = line.getAttributes()
        assertTrue(attributes is ShapeAttributes.TwoPoints)

        val rp1 = attributes.point1
        val rp2 = attributes.point2

        // Same values
        assertEquals(p1.getX(), rp1.getX())
        assertEquals(p1.getY(), rp1.getY())
        assertEquals(p2.getX(), rp2.getX())
        assertEquals(p2.getY(), rp2.getY())

        // Different references
        assertNotSame(p1, rp1)
        assertNotSame(p2, rp2)
    }

    @Test
    fun testSlope() {
        val line = Line(Point(0.0, 0.0), Point(2.0, 2.0))
        assertEquals(1.0, line.slope())

        val horizontal = Line(Point(0.0, 0.0), Point(5.0, 0.0))
        assertEquals(0.0, horizontal.slope())

        val vertical = Line(Point(2.0, 0.0), Point(2.0, 5.0))
        assertEquals(null, vertical.slope())
    }

    @Test
    fun testLength() {
        val p1 = Point(0.0, 0.0)
        val p2 = Point(3.0, 4.0)
        val line = Line(p1, p2)

        assertEquals(5.0, line.length())
    }

    @Test
    fun testMove() {
        val p1 = Point(0.0, 0.0)
        val p2 = Point(1.0, 1.0)
        val line = Line(p1, p2)

        line.move(2.0, -1.0)

        assertEquals(2.0, p1.getX())
        assertEquals(-1.0, p1.getY())
        assertEquals(3.0, p2.getX())
        assertEquals(0.0, p2.getY())
    }
}