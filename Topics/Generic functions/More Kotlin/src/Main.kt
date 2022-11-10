// implement your function here
fun <T> countItem(list: List<T>, item: T): Int =
    list.count { it == item }