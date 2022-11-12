package blockchain

class Miner(private val blockchain: Blockchain): Thread() {
    override fun run() {
        val miner = currentThread()
        var block: Block?
        while (!blockchain.stopMining) {
            block = blockchain.createBlock(miner.id)
            if (block != null) {
                while (block.id == blockchain.currBlockId) blockchain.testOrAddBlock(block)
            }
        }
    }
}