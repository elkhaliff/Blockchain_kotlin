package blockchain

data class Block(val id: Int, val prevHash: String, val timeStamp: Long) {
    val currHash: String
        get() = StringUtil.applySha256("$id$timeStamp$prevHash")

    override fun toString() =
        """
            Block:
            Id: $id
            Timestamp: $timeStamp
            Hash of the previous block:
            $prevHash
            Hash of the block:
            $currHash
        """
        .trimIndent()

}