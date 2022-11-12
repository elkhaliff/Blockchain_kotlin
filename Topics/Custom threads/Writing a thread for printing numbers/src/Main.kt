class NumbersThread(private val min: Int, private val max: Int) : Thread() {
    override fun run() = (min..max).forEach(::println)
}