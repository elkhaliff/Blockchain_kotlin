package blockchain

class Blockchain {
    private val blocks = mutableListOf<Block>()

    fun createBlock() {
        val prevBlock = blocks.getOrNull(blocks.lastIndex)
        val block = Block(
            prevBlock?.id?.plus(1) ?: 1,
            prevBlock?.currHash ?: "0",
            System.currentTimeMillis()
        )
        blocks.add(block)
    }

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