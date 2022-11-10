fun main() =
    List(readLine()!!.toInt()) { readLine()!!.toInt() }.sorted().let {
        if (it.size > 1) print(it[it.lastIndex] * it[it.lastIndex - 1]) else print(it[it.lastIndex])
    }