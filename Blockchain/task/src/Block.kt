package blockchain

data class Block(val idMiner: Long, val id: Int, val prevHash: String, var magicNumber: Long,
                 val timeStamp: Long, var timeEnd: Long,
                 val messages: String
                 ) {

    var shift: Int = 0

    val currHash: String
        get() = StringUtil.applySha256("$id$timeStamp$prevHash$magicNumber$messages")

    val seconds: Long
        get() = (timeEnd - timeStamp) / 1000


    override fun toString() =
        """
            Block:
            Created by miner # $idMiner
            miner$idMiner gets 100 VC
            Id: $id
            Timestamp: $timeStamp
            Magic number: $magicNumber
            Hash of the previous block:
            $prevHash
            Hash of the block:
            $currHash
            Block data:
            ${messages.ifEmpty { "no messages" }}
            Block was generating for $seconds seconds
            ${if (shift > 0) "N was increased to $shift" else "N was decreased by 1"}
        """
        .trimIndent()

}