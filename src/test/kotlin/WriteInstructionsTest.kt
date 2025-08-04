import Instructions.WriteInstruction
import kotlin.test.Test
import kotlin.test.assertEquals

class WriteInstructionTest {

    private val computer = Computer()
    private val instruction = WriteInstruction(computer)

    @Test
    fun `writes register value to memory at address A`() {
        computer.setRegister(1, 42)
        computer.setA(100)
        instruction.execute(0x01, 0x00) // reg 1 → memory[100]
        assertEquals(42, computer.readByte(100))
    }

    @Test
    fun `writes zero to memory`() {
        computer.setRegister(2, 0)
        computer.setA(123)
        instruction.execute(0x02, 0x00) // reg 2 → memory[123]
        assertEquals(0, computer.readByte(123))
    }

    @Test
    fun `writes max value to memory`() {
        computer.setRegister(3, 255)
        computer.setA(200)
        instruction.execute(0x03, 0x00) // reg 3 → memory[200]
        assertEquals(255, computer.readByte(200))
    }

    @Test
    fun `overwrites existing memory value`() {
        computer.writeByte(150, 99)
        computer.setRegister(4, 7)
        computer.setA(150)
        instruction.execute(0x04, 0x00)
        assertEquals(7, computer.readByte(150))
    }

    @Test
    fun `writes to different addresses as A changes`() {
        computer.setRegister(5, 88)

        computer.setA(10)
        instruction.execute(0x05, 0x00)
        assertEquals(88, computer.readByte(10))

        computer.setRegister(6, 90)
        computer.setA(11)
        instruction.execute(0x06, 0x00)
        assertEquals(90, computer.readByte(11))
    }
}