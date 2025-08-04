import kotlin.test.Test
import kotlin.test.assertEquals

class JumpByteManagerTest {

    private val manager = JumpByteManager()

    @Test
    fun `splits 0x00 and 0x00 correctly`() {
        val result = manager.splitBytes(0x00, 0x00)
        assertEquals(listOf(0, 0), result)
    }

    @Test
    fun `parses operation and address from 0x12 and 0x34`() {
        val result = manager.splitBytes(0x12, 0x34)
        // op = 0x1 = 1, address = (0x2 << 8) | 0x34 = 0x234 = 564
        assertEquals(listOf(1, 0x234), result)
    }

    @Test
    fun `parses maximum address 0xFF and 0xFF`() {
        val result = manager.splitBytes(0xFF, 0xFF)
        // op = 0xF = 15, address = (0xF << 8) | 0xFF = 0xFFF = 4095
        assertEquals(listOf(0xF, 0xFFF), result)
    }

    @Test
    fun `parses minimum address 0x10 and 0x00`() {
        val result = manager.splitBytes(0x10, 0x00)
        // op = 1, addrNibble = 0 → address = 0x000
        assertEquals(listOf(1, 0x000), result)
    }

    @Test
    fun `address uses lower nibble and full byte2`() {
        val result = manager.splitBytes(0xAB, 0xCD)
        // op = 0xA = 10, addr = (0xB << 8) | 0xCD = 0xBCD = 3021
        assertEquals(listOf(0xA, 0xBCD), result)
    }

    @Test
    fun `result always has two values`() {
        val result = manager.splitBytes(0x20, 0x10)
        assertEquals(2, result.size)
    }
}