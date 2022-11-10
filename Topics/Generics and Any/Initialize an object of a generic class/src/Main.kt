class Holder<T>(val value: T) {
    fun get(): T = value
}
fun main() {
    val holder = Holder("This is an instance of String")
    print(holder.get())
}