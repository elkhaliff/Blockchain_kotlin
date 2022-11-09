import kotlinx.datetime.*

fun daysForward(date: String, days: Int) {
    println(LacalDate(date).plus(days))
}

fun main() {
    val date = readLine()!!
    val days = readLine()!!.toInt()
    daysForward(date, days)
}