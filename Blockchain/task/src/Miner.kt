package blockchain

class Miner(private val blockchain: Blockchain): Thread() {
    override fun run() {
        val miner = currentThread()
        while (!blockchain.stopMining) {
            sleep(2000)
            blockchain.createBlock(miner.id)
        }
    }
}