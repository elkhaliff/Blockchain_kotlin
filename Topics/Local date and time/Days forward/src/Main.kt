import kotlinx.datetime.DatePeriod
import kotlinx.datetime.plus
import kotlinx.datetime.toLocalDate

fun daysForward(date: String, days: Int) =
    println(date.toLocalDate().plus(DatePeriod(days = days)))

fun main() {
    val date = readLine()!!
    val days = readLine()!!.toInt()
    daysForward(date, days)
}