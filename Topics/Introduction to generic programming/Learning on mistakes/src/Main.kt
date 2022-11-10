data class Container<T>(val t: T) {
    var value = t
}

fun main() {
    val container = Container<String>("Good job!")
    println(container.value)

}