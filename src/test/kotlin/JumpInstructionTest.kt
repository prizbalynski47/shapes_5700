import Instructions.JumpInstruction
import kotlin.test.Test
import kotlin.test.assertEquals

class JumpInstructionTest {

    private val computer = Computer()
    private val instruction = JumpInstruction(computer)

    @Test
    fun `sets program counter to given address`() {
        instruction.execute(0x01, 0x00) // Let's say this encodes address 0x0100 = 256
        assertEquals(256, computer.getP())
    }

    @Test
    fun `sets program counter to max address`() {
        instruction.execute(0x0F, 0xFE) // 0xFFFE = 65534
        assertEquals(0x0FFE, computer.getP())
    }

    @Test
    fun `sets program counter to minimum address`() {
        instruction.execute(0x00, 0x00)
        assertEquals(0, computer.getP())
    }

    @Test
    fun `jump does not increment program counter`() {
        computer.incrementP() // simulate it previously at 2
        computer.incrementP() // now P = 2
        instruction.execute(0x00, 0x04) // set to 4
        assertEquals(4, computer.getP(), "JumpInstruction should not auto-increment")
    }

    @Test
    fun `jump overwrites any existing program counter value`() {
        computer.setP(100)
        instruction.execute(0x00, 0x20)
        assertEquals(32, computer.getP())
    }
}