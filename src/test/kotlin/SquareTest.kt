import kotlin.test.*

class SquareTest {

    @Test
    fun testValidSquare() {
        val p1 = Point(0.0, 0.0)
        val p2 = Point(2.0, 2.0)
        val square = Square(p1, p2)

        assertEquals(4.0, square.getArea())
    }

    @Test
    fun testInvalidSquare() {
        val p1 = Point(0.0, 0.0)
        val p2 = Point(3.0, 2.0) // width = 3, height = 2

        val exception = assertFailsWith<IllegalArgumentException> {
            Square(p1, p2)
        }

        assertTrue(exception.message!!.contains("equal width and height"))
    }

    @Test
    fun testSquareInheritsMove() {
        val p1 = Point(1.0, 1.0)
        val p2 = Point(3.0, 3.0)
        val square = Square(p1, p2)

        square.move(2.0, -1.0)

        assertEquals(3.0, p1.getX())
        assertEquals(0.0, p1.getY())
        assertEquals(5.0, p2.getX())
        assertEquals(2.0, p2.getY())
    }
}