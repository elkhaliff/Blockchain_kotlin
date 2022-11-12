import kotlin.concurrent.thread

fun main() {
    val numbersFilter = thread(
        block = {
            do {
                val n = readln().toInt()
                if (n != 0 && n % 2 == 0) println(n)
            } while (n != 0)
        }
    )
}