import Instructions.SkipNotEqualInstruction
import kotlin.test.Test
import kotlin.test.assertEquals

class SkipNotEqualInstructionTest {

    private val computer = Computer()
    private val instruction = SkipNotEqualInstruction(computer)

    @Test
    fun `does not skip when values are equal`() {
        computer.setRegister(1, 42)
        computer.setRegister(2, 42)
        val originalP = computer.getP()
        instruction.execute(0x01, 0x20) // Compare R1 and R2
        assertEquals(originalP + 2, computer.getP()) // Just the base increment
    }

    @Test
    fun `skips when values are different`() {
        computer.setRegister(1, 10)
        computer.setRegister(2, 20)
        val originalP = computer.getP()
        instruction.execute(0x01, 0x20)
        assertEquals(originalP + 4, computer.getP()) // One from base, one from skip
    }

    @Test
    fun `does not skip when both values are zero`() {
        computer.setRegister(3, 0)
        computer.setRegister(4, 0)
        val originalP = computer.getP()
        instruction.execute(0x03, 0x40)
        assertEquals(originalP + 2, computer.getP())
    }

    @Test
    fun `skips when only one is zero`() {
        computer.setRegister(5, 0)
        computer.setRegister(6, 255)
        val originalP = computer.getP()
        instruction.execute(0x05, 0x60)
        assertEquals(originalP + 4, computer.getP())
    }

    @Test
    fun `skips when both registers have non-zero different values`() {
        computer.setRegister(7, 100)
        computer.setRegister(0, 101)
        val originalP = computer.getP()
        instruction.execute(0x07, 0x00)
        assertEquals(originalP + 4, computer.getP())
    }
}