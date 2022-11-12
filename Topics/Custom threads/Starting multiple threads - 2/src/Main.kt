fun main() = repeat("3".toInt()) { Thread(RunnableWorker(), "worker-$it").start() }

class RunnableWorker : Runnable {
    override fun run() {
        val name = Thread.currentThread().name
        if (name.startsWith("worker-")) {
            println("too hard calculations...")
        } else {
            return
        }
    }
}