import Instructions.ConvertToBase10Instruction
import kotlin.test.Test
import kotlin.test.assertEquals

class ConvertToBase10InstructionTest {

    private val computer = Computer()
    private val instruction = ConvertToBase10Instruction(computer)

    @Test
    fun `converts 0 to 000`() {
        computer.setRegister(1, 0)
        computer.setA(100)
        instruction.execute(0x01, 0x00)
        assertEquals(0, computer.readByte(100))
        assertEquals(0, computer.readByte(101))
        assertEquals(0, computer.readByte(102))
    }

    @Test
    fun `converts 7 to 007`() {
        computer.setRegister(1, 7)
        computer.setA(200)
        instruction.execute(0x01, 0x00)
        assertEquals(0, computer.readByte(200))
        assertEquals(0, computer.readByte(201))
        assertEquals(7, computer.readByte(202))
    }

    @Test
    fun `converts 42 to 042`() {
        computer.setRegister(1, 42)
        computer.setA(150)
        instruction.execute(0x01, 0x00)
        assertEquals(0, computer.readByte(150))   // hundreds
        assertEquals(4, computer.readByte(151))   // tens
        assertEquals(2, computer.readByte(152))   // ones
    }

    @Test
    fun `converts 255 to 255`() {
        computer.setRegister(1, 255)
        computer.setA(250)
        instruction.execute(0x01, 0x00)
        assertEquals(2, computer.readByte(250))   // hundreds
        assertEquals(5, computer.readByte(251))   // tens
        assertEquals(5, computer.readByte(252))   // ones
    }

    @Test
    fun `converts 100 to 100`() {
        computer.setRegister(1, 100)
        computer.setA(50)
        instruction.execute(0x01, 0x00)
        assertEquals(1, computer.readByte(50))
        assertEquals(0, computer.readByte(51))
        assertEquals(0, computer.readByte(52))
    }

    @Test
    fun `converts 99 to 099`() {
        computer.setRegister(1, 99)
        computer.setA(10)
        instruction.execute(0x01, 0x00)
        assertEquals(0, computer.readByte(10))
        assertEquals(9, computer.readByte(11))
        assertEquals(9, computer.readByte(12))
    }
}