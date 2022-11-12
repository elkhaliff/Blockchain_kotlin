fun printCurrentThreadInfo() = with(Thread.currentThread()) {
    println("name: $name\npriority: $priority")
}