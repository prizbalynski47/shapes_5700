import Instructions.AddInstruction
import kotlin.test.Test
import kotlin.test.assertEquals


class AddInstructionTest {

    private val computer = Computer()
    private val instruction = AddInstruction(computer)

    @Test
    fun `basic addition stores correct result`() {
        computer.setRegister(1, 10)
        computer.setRegister(2, 20)
        instruction.execute(0x01, 0x23)
        assertEquals(30, computer.getRegister(3))
    }

    @Test
    fun `result wraps around with overflow beyond 255`() {
        computer.setRegister(1,200)
        computer.setRegister(2,100)
        val operands = listOf(0, 1, 2, 4) // Add R1 + R2 -> R4
        instruction.execute(0x01, 0x24)
        assertEquals((200 + 100) and 0xFF, computer.getRegister(4)) // Expected: 44
    }

    @Test
    fun `adding zero does not change value`() {
        computer.setRegister(1,123)
        computer.setRegister(2,0)
        instruction.execute(0x01,0x25)
        assertEquals(123, computer.getRegister(5))
    }

    @Test
    fun `adding two zeros results in zero`() {
        computer.setRegister(0,0)
        computer.setRegister( 1,0)
        instruction.execute(0x00, 0x16)
        assertEquals(0, computer.getRegister(6))
    }

    @Test
    fun `handles maximum values correctly`() {
        computer.setRegister(1,255)
        computer.setRegister(2,255)
        instruction.execute(0x01,0x27)
        assertEquals((255 + 255) and 0xFF, computer.getRegister(7)) // Expected: 254
    }
}