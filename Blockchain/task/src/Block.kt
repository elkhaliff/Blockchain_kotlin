package blockchain

data class Block(val id: Int, val prevHash: String, var magicNumber: Long, val timeStamp: Long, var timeEnd: Long) {

    val currHash: String
        get() = StringUtil.applySha256("$id$timeStamp$prevHash$magicNumber")

    override fun toString() =
        """
            Block:
            Id: $id
            Timestamp: $timeStamp
            Magic number: $magicNumber
            Hash of the previous block:
            $prevHash
            Hash of the block:
            $currHash
            Block was generating for ${((timeEnd - timeStamp) / 1000).toInt()} seconds
        """
        .trimIndent()

}