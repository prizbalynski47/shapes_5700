import Instructions.StoreInstruction
import kotlin.test.Test
import kotlin.test.assertEquals

class StoreInstructionTest {

    private val computer = Computer()
    private val instruction = StoreInstruction(computer)

    @Test
    fun `stores literal value in register`() {
        instruction.execute(0x01, 0x2A) // Store 0x2A into register 1
        assertEquals(0x2A, computer.getRegister(1))
    }

    @Test
    fun `stores zero value in register`() {
        instruction.execute(0x03, 0x00) // Store 0 into register 3
        assertEquals(0, computer.getRegister(3))
    }

    @Test
    fun `stores maximum byte value`() {
        instruction.execute(0x07, 0xFF) // Store 255 into register 7
        assertEquals(255, computer.getRegister(7))
    }

    @Test
    fun `overwrites existing value in register`() {
        computer.setRegister(5, 123)
        instruction.execute(0x05, 0x01) // Store 1 into register 5
        assertEquals(1, computer.getRegister(5))
    }

    @Test
    fun `stores same value already in register`() {
        computer.setRegister(2, 42)
        instruction.execute(0x02, 0x2A) // Store 42 into register 2
        assertEquals(42, computer.getRegister(2))
    }
}