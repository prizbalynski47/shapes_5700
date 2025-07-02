import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotSame

class RectangleTest {

    @Test
    fun testGetArea() {
        val p1 = Point(0.0, 0.0)
        val p2 = Point(2.0, 2.0)
        val rect = Rectangle(p1, p2)
        assertEquals(4.0, rect.getArea())
    }

    @Test
    fun testAreaNotZero() {
        val p1 = Point(0.0, 0.0)
        val p2 = Point(0.0, 0.0)

        val exception = assertFailsWith<IllegalArgumentException> {
            Rectangle(p1, p2)
        }
    }

    @Test
    fun testGetAttributes() {
        val p1 = Point(1.0, 1.0)
        val p2 = Point(3.0, 4.0)
        val rect = Rectangle(p1, p2)

        val attributes = rect.getAttributes()

        val returnedP1 = attributes.point1
        val returnedP2 = attributes.point2

        // Should have same values:
        assertEquals(p1.getX(), returnedP1.getX())
        assertEquals(p1.getY(), returnedP1.getY())
        assertEquals(p2.getX(), returnedP2.getX())
        assertEquals(p2.getY(), returnedP2.getY())

        // But not same reference:
        assertNotSame(p1, returnedP1)
        assertNotSame(p2, returnedP2)
    }

    @Test
    fun testMove() {
        val p1 = Point(0.0, 0.0)
        val p2 = Point(2.0, 2.0)
        val rect = Rectangle(p1, p2)

        rect.move(1.0, 1.0)

        assertEquals(1.0, p1.getX())
        assertEquals(1.0, p1.getY())
        assertEquals(3.0, p2.getX())
        assertEquals(3.0, p2.getY())
    }
}