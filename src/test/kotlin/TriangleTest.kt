import kotlin.test.*

class TriangleTest {

    @Test
    fun testGetArea() {
        val p1 = Point(0.0, 0.0)
        val p2 = Point(4.0, 0.0)
        val p3 = Point(0.0, 3.0)
        val triangle = Triangle(p1, p2, p3)

        val expectedArea = 6.0 // (1/2) * base * height = 1/2 * 4 * 3
        assertEquals(expectedArea, triangle.getArea())
    }

    @Test
    fun testAreaNotZero1() {
        val p1 = Point(1.0, 1.0)
        val p2 = Point(1.0, 1.0)
        val p3 = Point(1.0, 1.0)

        val exception = assertFailsWith<IllegalArgumentException> {
            Triangle(p1, p2, p3)
        }
        assertTrue(exception.message!!.contains("greater than zero"))
    }

    @Test
    fun testAreaNotZero2() {
        val p1 = Point(0.0, 0.0)
        val p2 = Point(1.0, 1.0)
        val p3 = Point(2.0, 2.0) // All on line y = x

        val exception = assertFailsWith<IllegalArgumentException> {
            Triangle(p1, p2, p3)
        }
        assertTrue(exception.message!!.contains("greater than zero"))
    }

    @Test
    fun testGetAttributes() {
        val p1 = Point(0.0, 0.0)
        val p2 = Point(1.0, 0.0)
        val p3 = Point(0.0, 1.0)
        val triangle = Triangle(p1, p2, p3)

        val attributes = triangle.getAttributes()
        assertTrue(attributes is ShapeAttributes.ThreePoints)

        val rp1 = attributes.point1
        val rp2 = attributes.point2
        val rp3 = attributes.point3

        // Correct values
        assertEquals(p1.getX(), rp1.getX())
        assertEquals(p1.getY(), rp1.getY())
        assertEquals(p2.getX(), rp2.getX())
        assertEquals(p2.getY(), rp2.getY())
        assertEquals(p3.getX(), rp3.getX())
        assertEquals(p3.getY(), rp3.getY())

        // Not same references
        assertNotSame(p1, rp1)
        assertNotSame(p2, rp2)
        assertNotSame(p3, rp3)
    }

    @Test
    fun testMove() {
        val p1 = Point(0.0, 0.0)
        val p2 = Point(1.0, 0.0)
        val p3 = Point(0.0, 1.0)
        val triangle = Triangle(p1, p2, p3)

        triangle.move(2.0, -1.0)

        assertEquals(2.0, p1.getX())
        assertEquals(-1.0, p1.getY())
        assertEquals(3.0, p2.getX())
        assertEquals(-1.0, p2.getY())
        assertEquals(2.0, p3.getX())
        assertEquals(0.0, p3.getY())
    }
}