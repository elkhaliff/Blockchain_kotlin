package blockchain

import java.util.concurrent.ThreadLocalRandom

class Blockchain(zerosCnt: Int) {
    private val zeros: String = "0".repeat(zerosCnt)

    private val blocks = mutableListOf<Block>()

    private var magicNumber = generateNumber()
    fun createBlock() {
        val prevBlock = blocks.getOrNull(blocks.lastIndex)
        val block = Block(
            prevBlock?.id?.plus(1) ?: 1,
            prevBlock?.currHash ?: "0",
            magicNumber,
            System.currentTimeMillis(),
            System.currentTimeMillis()
        )
        while (checkZero(block.currHash)) {
            block.magicNumber = generateNumber()
            block.timeEnd = System.currentTimeMillis()
        }
        blocks.add(block)
    }

    private fun checkZero(currHash: String) = !currHash.startsWith(zeros)

    private fun generateNumber() = ThreadLocalRandom.current().nextLong(Long.MAX_VALUE)

    fun validChain(): Boolean {
        if (blocks.size == 0) return true
        if (blocks[0].prevHash != "0") return false
        for (idx in blocks.lastIndex downTo 1) {
            if (blocks[idx].prevHash != blocks[idx - 1].currHash) return false
        }
        return true
    }

    fun printChain() {
        blocks.forEach {
            println(it.toString())
            println()
        }
    }
}