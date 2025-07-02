import kotlin.test.*
import kotlin.math.PI

class CircleTest {

    @Test
    fun testValidCircle() {
        val p = Point(0.0, 0.0)
        val r = 3.0
        val circle = Circle(p, r, r)

        val expectedArea = PI * r * r
        assertEquals(expectedArea, circle.getArea())
    }

    @Test
    fun testInvalidCircle() {
        val p = Point(0.0, 0.0)
        val r1 = 3.0
        val r2 = 2.0

        val exception = assertFailsWith<IllegalArgumentException> {
            Circle(p, r1, r2)
        }

        assertTrue(exception.message!!.contains("equal radii"))
    }

    @Test
    fun testInheritsMove() {
        val p = Point(1.0, 1.0)
        val circle = Circle(p, 2.0, 2.0)

        circle.move(-1.0, 3.0)

        assertEquals(0.0, p.getX())
        assertEquals(4.0, p.getY())
    }
}