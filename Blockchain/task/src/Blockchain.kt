package blockchain

import java.util.*

class Blockchain(@Volatile var zerosCnt: Int, private val chainCnt: Int) {
    private val isDebug = false // необходимость печати отладочной информации

//    val chatBot: ChatBot

    @Volatile
    var stopMining = false
    private val zeros: String
        get() = "0".repeat(zerosCnt)

    private var messages = ""
    private val blocks = mutableListOf<Block>()
    private val maxSecondForMining = 15 // Максимальное время нахождения блока с заданным количеством нулей

    private val initMessage: Boolean
        get() = (blocks.size > 0)

    /*init {
        chatBot = ChatBot(this)
        chatBot.start()
    }*/

    @Synchronized
    fun createBlock(idMiner: Long) {
        if (blocks.size >= chainCnt) { stopMining = true; return }
        if (initMessage) addMessage(ChatBot.getAnyMessage())

        val prevBlock = blocks.getOrNull(blocks.lastIndex)
        val block = Block(idMiner,
            prevBlock?.id?.plus(1) ?: 1,
            prevBlock?.currHash ?: "0",
            generateNumber(),
            System.currentTimeMillis(),
            System.currentTimeMillis(),
            messages
        )
        while (checkZero(block.currHash)) {
            block.magicNumber = generateNumber()
            block.timeEnd = System.currentTimeMillis()
        }

        if (validChain() && (blocks.size < chainCnt)) {
            blocks.add(block)
            testZero(block)
            messages = ""
        }
        if (blocks.size >= chainCnt) stopMining = true
    }

    @Synchronized
    private fun testZero(block: Block) {
        if (block.seconds < maxSecondForMining) {
            zerosCnt++
            block.shift = zerosCnt
        }
        else {
            zerosCnt--
            block.shift = -zerosCnt
        }
        say(zeros)
    }

    @Synchronized
    fun addMessage(message: String) {
        if (!messages.isEmpty()) messages += "\n"
        messages += message
        say(message)
    }

    private fun checkZero(currHash: String) = !currHash.startsWith(zeros)

    private fun generateNumber() = Random().nextLong(Long.MAX_VALUE)

    private fun validChain(): Boolean {
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

    fun createMiners(cntMiners: Int) {
        val miners = mutableListOf<Miner>()
        repeat(cntMiners) { miners.add(Miner(this)) }
        (0 until cntMiners).forEach { miners[it].start() }
        (0 until cntMiners).forEach { miners[it].join() }
        //chatBot.join()
    }

    private fun say(msg: String) {
        if (isDebug) println("\n !!! $msg !!! \n")
    }
}