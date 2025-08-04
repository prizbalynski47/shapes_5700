import Instructions.SetAInstruction
import kotlin.test.Test
import kotlin.test.assertEquals

class SetAInstructionTest {

    private val computer = Computer()
    private val instruction = SetAInstruction(computer)

    @Test
    fun `sets A register to given address`() {
        instruction.execute(0x01, 0x23) // Address = 0x0123 = 291
        assertEquals(0x0123, computer.getA())
    }

    @Test
    fun `sets A register to zero`() {
        instruction.execute(0x00, 0x00)
        assertEquals(0, computer.getA())
    }

    @Test
    fun `sets A register to max value`() {
        instruction.execute(0x0F, 0xFF) // 65535
        assertEquals(0x0FFF, computer.getA())
    }

    @Test
    fun `overwrites existing A value`() {
        computer.setA(100)
        instruction.execute(0x00, 0x10)
        assertEquals(0x10, computer.getA())
    }
}