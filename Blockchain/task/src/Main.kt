package blockchain

fun main() {
    print("Enter how many zeros the hash must start with: ")
    val zeros = readln().toInt()
    println()

    val blockchain = Blockchain(zeros)
    repeat(5) {
        blockchain.createBlock()
        if (!blockchain.validChain()) println("Chain is NOT VALID!!!")
    }
    blockchain.printChain()
}