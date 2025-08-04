import Instructions.StoreInstruction
import Instructions.SwitchMemoryInstruction
import kotlin.test.Test
import kotlin.test.assertEquals

class SwitchMemoryInstructionTest {

    private val computer = Computer()
    private val instruction = SwitchMemoryInstruction(computer)

    @Test
    fun `toggles memory mode from false to true`() {
        // Initially false
        assertEquals(false, computer.getM())
        instruction.execute(0x00, 0x00)
        assertEquals(true, computer.getM())
    }

    @Test
    fun `toggles memory mode from true to false`() {
        computer.toggleM() // Set to true
        instruction.execute(0x00, 0x00)
        assertEquals(false, computer.getM())
    }

    @Test
    fun `program counter increments after switch`() {
        val originalP = computer.getP()
        instruction.execute(0x00, 0x00)
        assertEquals(originalP + 2, computer.getP())
    }
}