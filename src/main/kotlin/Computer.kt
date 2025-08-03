class Computer(
    private val cpu: CPU,
    private val ram: RAM,
    private val rom: ROM,
    private val screen: Screen,
) {
    private val instructionHandler = InstructionHandler { readAndExecuteInstruction() }

    fun getRegister(register: Int): Int {
        return cpu.getRegister(register)
    }

    fun setRegister(register: Int, value: Int) {
        cpu.setRegister(register, value)
    }

    fun setP(address: Int) {
        cpu.setP(address)
    }

    fun incrementP() {
        cpu.incrementP()
    }

    fun getP(): Int {
        return cpu.getP()
    }

    fun setT(time: Int) {
        cpu.setT(time)
    }

    fun getT(): Int {
        return cpu.getT()
    }

    fun setA(address: Int) {
        cpu.setA(address)
    }

    fun getA(): Int {
        return cpu.getA()
    }

    fun toggleM() {
        cpu.toggleM()
    }

    fun getM(): Boolean {
        return cpu.getM()
    }

    fun readByte(address: Int, romSelected: Boolean): Int {
        if (romSelected) {
            return rom.readByte(address)
        }
        return ram.readByte(address)
    }

    fun writeByte(address: Int, value: Int, romSelected: Boolean){
        if (romSelected) {
            rom.writeByte(address, value)
        } else {
            ram.writeByte(address, value)
        }
    }

    protected fun readAndExecuteInstruction() {
        val p = cpu.getP()
        val byte1 = rom.readByte(p)
        val byte2 = rom.readByte(p+1)
        val instructionType = byte1 shr 4
        val instruction = when (instructionType) {
            0x0 -> StoreInstruction(this)
            0x1 -> AddInstruction(this)
            0x2 -> SubInstruction(this)
            0x3 -> ReadInstruction(this)
            0x4 -> WriteInstruction(this)
            0x5 -> JumpInstruction(this)
            0x6 -> ReadKeyboardInstruction(this)
            0x7 -> SwitchMemoryInstruction(this)
            0x8 -> SkipEqualInstruction(this)
            0x9 -> SkipNotEqualInstruction(this)
            0xA -> SetAInstruction(this)
            0xB -> SetTInstruction(this)
            0xC -> ReadTInstruction(this)
            0xD -> ConvertToBase10Instruction(this)
            0xE -> ConvertByteToAsciiInstruction(this)
            0xF -> DrawInstruction(this)
            else -> error("Unknown Instruction")
        }
        instruction.execute(byte1, byte2)
    }

    fun pause() {
        instructionHandler.pause()
    }

    fun resume() {
        instructionHandler.resume()
    }
}