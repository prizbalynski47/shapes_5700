import Instructions.ConvertByteToAsciiInstruction
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class ConvertByteToAsciiInstructionTest {

    private val computer = Computer()
    private val instruction = ConvertByteToAsciiInstruction(computer)

    @Test
    fun `throws error for value greater than 15`() {
        computer.setRegister(1, 16)
        val exception = assertFailsWith<IllegalStateException> {
            instruction.execute(0x01, 0x10) // R1 -> R2
        }
        assertEquals("Register value too large", exception.message)
    }

    @Test
    fun `all values 0 to 15 convert correctly to ascii`() {
        for (value in 0..15) {
            computer.setRegister(0, value)
            instruction.execute(0x00, 0x50)
            val expectedChar = if (value < 10) '0' + value else 'A' + (value - 10)
            assertEquals(expectedChar.code, computer.getRegister(5), "Failed at value $value")
        }
    }
}