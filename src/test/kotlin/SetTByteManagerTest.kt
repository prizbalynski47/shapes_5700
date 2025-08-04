import kotlin.test.Test
import kotlin.test.assertEquals

class SetTByteManagerTest {

    private val manager = SetTByteManager()

    @Test
    fun `parses 0x00 and 0x00 correctly`() {
        val result = manager.splitBytes(0x00, 0x00)
        assertEquals(listOf(0, 0), result)
    }

    @Test
    fun `parses 0x12 and 0x30 correctly`() {
        val result = manager.splitBytes(0x12, 0x30)
        // op = 1, newTimeFirstNibble = 2, byte2 shr 4 = 3
        // newTime = (2 << 4) | 3 = 35
        assertEquals(listOf(0x1, 0x23), result)
    }

    @Test
    fun `parses 0xFF and 0xF0 correctly`() {
        val result = manager.splitBytes(0xFF, 0xF0)
        // op = 15, newTimeFirstNibble = 15, byte2 shr 4 = 15
        // newTime = (15 << 4) | 15 = 0xFF = 255
        assertEquals(listOf(0xF, 0xFF), result)
    }

    @Test
    fun `parses 0xA7 and 0xB0 correctly`() {
        val result = manager.splitBytes(0xA7, 0xB0)
        // op = 10, newTimeNibble = 7, byte2 shr 4 = 11
        // newTime = (7 << 4) | 11 = 123
        assertEquals(listOf(0xA, 0x7B), result)
    }

    @Test
    fun `parses minimum operation and maximum newTime`() {
        val result = manager.splitBytes(0x0F, 0xF0)
        // op = 0, newTime = (15 << 4) | 15 = 255
        assertEquals(listOf(0, 0xFF), result)
    }

    @Test
    fun `result always has two values`() {
        val result = manager.splitBytes(0xAB, 0xCD)
        assertEquals(2, result.size)
    }
}