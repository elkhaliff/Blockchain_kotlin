class MessageNotifier(private val msg: String, private val cnt: Int) : Thread() { // implement the constructor
    override fun run() = repeat(cnt) { println(msg) }
}