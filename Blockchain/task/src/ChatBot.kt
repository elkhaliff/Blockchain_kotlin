package blockchain

import java.util.*

private val MESSAGES = listOf(
/*    "Ash tree did not answer me, shaking his head.",
    "I asked the ash tree where my beloved is.",
    "I asked the poplar: \"Where is my beloved?\"",
    "The poplar showered me with autumn leaves.",
    "I asked autumn: \"Where is my beloved?\"",
    "Autumn answered me with pouring rain.",
    "I asked the rain where my love is.",
    "For a long time the rain poured tears outside my window.",
    "I asked the moon: \"Where is my beloved?\"",
    "The moon hid in a cloud - did not answer me.",
    "I asked the cloud: \"Where is my beloved?\"",
    "The cloud melted into the blue of the sky...",
    "You are my only friend, where is my love?",
    "You tell me where you hid, do you know where she is?",
    "A friend answered a devotee, a friend answered a sincere one,",
    "You were loved, you were loved.",
    "You were loved, but my wife became."
*/
    "miner9 sent 10 VC to Bob",
    "miner7 sent 10 VC to Alice",
    "Nick sent 1 VC to ShoesShop",
    "Nick sent 2 VC to FastFood",
    "Nick sent 15 VC to CarShop",
    "miner7 sent 90 VC to CarShop"
)
/*
class ChatBot(private val blockchain: Blockchain): Thread() {
    override fun run() {
        while (!blockchain.stopMining) {
//            if (blockchain.initMessage)
                blockchain.addMessage(MESSAGES[Random().nextInt(MESSAGES.size - 1)])
            sleep(200)
        }
    }
}
*/
class ChatBot {
    companion object {
        fun getAnyMessage() = MESSAGES[Random().nextInt(MESSAGES.size - 1)]
    }
}