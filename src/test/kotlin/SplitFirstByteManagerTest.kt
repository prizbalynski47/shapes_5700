import kotlin.test.Test
import kotlin.test.assertEquals

class SplitFirstByteManagerTest {

    private val manager = SplitFirstByteManager()

    @Test
    fun `splits 0x00 and 0x00 correctly`() {
        val result = manager.splitBytes(0x00, 0x00)
        assertEquals(listOf(0, 0, 0), result)
    }

    @Test
    fun `splits 0xF0 and 0x00 correctly`() {
        val result = manager.splitBytes(0xF0, 0x00)
        assertEquals(listOf(15, 0, 0), result)
    }

    @Test
    fun `splits 0x0F and 0x00 correctly`() {
        val result = manager.splitBytes(0x0F, 0x00)
        assertEquals(listOf(0, 15, 0), result)
    }

    @Test
    fun `splits 0xAB and 0xCD correctly`() {
        val result = manager.splitBytes(0xAB, 0xCD)
        // 0xAB → A = 10, B = 11
        assertEquals(listOf(10, 11, 0xCD), result)
    }

    @Test
    fun `splits 0xFF and 0xFF correctly`() {
        val result = manager.splitBytes(0xFF, 0xFF)
        assertEquals(listOf(15, 15, 255), result)
    }

    @Test
    fun `result is always 3 values`() {
        val result = manager.splitBytes(0xDE, 0xAD)
        assertEquals(3, result.size)
    }
}