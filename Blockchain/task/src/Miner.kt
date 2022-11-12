package blockchain

class Miner(val blockchain: Blockchain): Thread() {
    override fun run() {
        val miner = currentThread()
        while (!blockchain.stopMining) {
            blockchain.createBlock(miner.id)
        }
    }
}