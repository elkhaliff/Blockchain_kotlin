// Fix this function
fun main() {
    val (from1Incl, to1Incl) = readLine()!!.split(" ").map { it.toInt() } // limits of the first range
    val (from2Incl, to2Incl) = readLine()!!.split(" ").map { it.toInt() } // limits of the second range

    val summator1 = RangeSummator(from1Incl, to1Incl) // first summator
    val summator2 = RangeSummator(from2Incl, to2Incl) // second summator

    summator1.start()
    summator1.join()

    summator2.start()
    summator2.join()

    val partialSum1 = summator1.result
    val partialSum2 = summator2.result
    val sum = partialSum1 + partialSum2 // the sum is 0, fix it!
    println(sum)
}

val mainThreadId = Thread.currentThread().id

class RangeSummator(var fromIncl: Int, var toIncl: Int) : Thread() {
    @Volatile
    var result: Long = 0
        private set

    override fun run() {
        val currentId = currentThread().id
        if (currentId == mainThreadId) {
            throw RuntimeException("You must start a new thread!")
        }
        var sum: Long = 0
        for (i in fromIncl..toIncl) {
            sum += i.toLong()
        }
        result = sum
    }
}