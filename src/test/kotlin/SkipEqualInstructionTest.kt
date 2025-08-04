import Instructions.SkipEqualInstruction
import kotlin.test.Test
import kotlin.test.assertEquals

class SkipEqualInstructionTest {

    private val computer = Computer()
    private val instruction = SkipEqualInstruction(computer)

    @Test
    fun `increments P once when values are not equal`() {
        computer.setRegister(1, 0x05)
        computer.setRegister(2, 0x0A)
        val originalP = computer.getP()
        instruction.execute(0x01, 0x20) // compare R1 and R2
        assertEquals(originalP + 2, computer.getP())
    }

    @Test
    fun `increments P twice when values are equal`() {
        computer.setRegister(1, 7)
        computer.setRegister(2, 7)
        val originalP = computer.getP()
        instruction.execute(0x01, 0x20) // compare R1 and R2
        assertEquals(originalP + 4, computer.getP()) // one from InstructionTemplate, one from skip
    }

    @Test
    fun `does not skip when registers hold different values`() {
        computer.setRegister(4, 0)
        computer.setRegister(5, 1)
        val originalP = computer.getP()
        instruction.execute(0x04, 0x50)
        assertEquals(originalP + 2, computer.getP())
    }

    @Test
    fun `skips when both registers hold zero`() {
        computer.setRegister(6, 0)
        computer.setRegister(7, 0)
        val originalP = computer.getP()
        instruction.execute(0x06, 0x70)
        assertEquals(originalP + 4, computer.getP())
    }

    @Test
    fun `skips when both registers hold 255`() {
        computer.setRegister(2, 255)
        computer.setRegister(3, 255)
        val originalP = computer.getP()
        instruction.execute(0x02, 0x30)
        assertEquals(originalP + 4, computer.getP())
    }
}