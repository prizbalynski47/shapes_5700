import kotlin.test.Test
import kotlin.test.assertEquals

class SplitBothByteManagerTest {

    private val manager = SplitBothByteManager()

    @Test
    fun `splits 0x00 and 0x00 correctly`() {
        val result = manager.splitBytes(0x00, 0x00)
        assertEquals(listOf(0, 0, 0, 0), result)
    }

    @Test
    fun `splits 0xF0 and 0x0F correctly`() {
        val result = manager.splitBytes(0xF0, 0x0F)
        assertEquals(listOf(0xF, 0, 0, 0xF), result)
    }

    @Test
    fun `splits 0xAB and 0xCD correctly`() {
        val result = manager.splitBytes(0xAB, 0xCD)
        assertEquals(listOf(0xA, 0xB, 0xC, 0xD), result)
    }

    @Test
    fun `splits 0xFF and 0xFF correctly`() {
        val result = manager.splitBytes(0xFF, 0xFF)
        assertEquals(listOf(0xF, 0xF, 0xF, 0xF), result)
    }

    @Test
    fun `splits 0x12 and 0x34 correctly`() {
        val result = manager.splitBytes(0x12, 0x34)
        assertEquals(listOf(1, 2, 3, 4), result)
    }

    @Test
    fun `result list always has 4 elements`() {
        val result = manager.splitBytes(0x56, 0x78)
        assertEquals(4, result.size)
    }
}