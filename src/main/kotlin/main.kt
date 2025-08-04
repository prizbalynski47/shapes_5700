import java.io.File

fun main () {
    val computer = Computer()
    println("Type in the path to the rom file: ")
    val filepath = readLine()

    val romBytes = File(filepath).readBytes()
    computer.loadRomFromBytes(romBytes)

    computer.run()
}