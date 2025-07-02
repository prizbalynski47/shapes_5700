import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotSame

class PointTest {

    @Test
    fun testConstructor() {
        val p = Point(3.0, 4.0)
        assertEquals(3.0, p.getX())
        assertEquals(4.0, p.getY())
    }

    @Test
    fun testClone() {
        val p1 = Point(1.0, 2.0)
        val p2 = p1.clone()

        assertNotSame(p1, p2, "Clone should create a new instance")
        assertEquals(p1.getX(), p2.getX())
        assertEquals(p1.getY(), p2.getY())
    }

    @Test
    fun testMove() {
        val p = Point(0.0, 0.0)
        p.move(5.0, -3.0)

        assertEquals(5.0, p.getX())
        assertEquals(-3.0, p.getY())
    }

    @Test
    fun testMultipleMoves() {
        val p = Point(1.0, 1.0)
        p.move(2.0, 3.0)
        p.move(-1.0, -1.0)

        assertEquals(2.0, p.getX())
        assertEquals(3.0, p.getY())
    }
}