package blockchain

fun main() {
    val blockchain = Blockchain()
    repeat(5) {
        blockchain.createBlock()
        if (!blockchain.validChain()) println("Chain is NOT VALID!!!")
    }
    blockchain.printChain()
}