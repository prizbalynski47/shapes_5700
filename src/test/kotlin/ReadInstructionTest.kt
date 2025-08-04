import Instructions.ReadInstruction
import kotlin.test.Test
import kotlin.test.assertEquals

class ReadInstructionTest {

    private val computer = Computer()
    private val instruction = ReadInstruction(computer)

    @Test
    fun `reads value from memory into register`() {
        computer.setA(100)
        computer.writeByte(100, 42)
        instruction.execute(0x01, 0x00) // reg 1 ← memory[100]
        assertEquals(42, computer.getRegister(1))
    }

    @Test
    fun `reads value zero into register`() {
        computer.setA(200)
        computer.writeByte(200, 0)
        instruction.execute(0x02, 0x00) // reg 2 ← memory[200]
        assertEquals(0, computer.getRegister(2))
    }

    @Test
    fun `reads max byte value into register`() {
        computer.setA(255)
        computer.writeByte(255, 255)
        instruction.execute(0x03, 0x00) // reg 3 ← memory[255]
        assertEquals(255, computer.getRegister(3))
    }

    @Test
    fun `overwrites existing register value`() {
        computer.setRegister(4, 99)
        computer.setA(150)
        computer.writeByte(150, 7)
        instruction.execute(0x04, 0x00) // reg 4 ← memory[150]
        assertEquals(7, computer.getRegister(4))
    }

    @Test
    fun `reads from rom when selected`() {
        computer.setA(123)
        computer.writeByte(123, 88)
        computer.toggleM()
        instruction.execute(0x05, 0x00) // reg 5 ← rom[123]
        assertEquals(0, computer.getRegister(5))
    }
}