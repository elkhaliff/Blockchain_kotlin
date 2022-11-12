package blockchain

fun main() {
    val blockchain = Blockchain(1, 5) // Инициализируем с одним "0", и ограничиваем 5 звеньями
    blockchain.createMiners(10) // Запустили, работают, ждем

    blockchain.printChain() // Печатаем что получилось
}