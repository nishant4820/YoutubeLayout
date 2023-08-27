package com.nishant4820.youtubelayout.data

class DataItemType {
    companion object {
        const val LONG_VIDEO = 0
        const val SHORTS = 1
    }
}

data class DataItem(val viewType: Int) {

    var shortsItemList: List<ShortsItem>? = null
    var longVideoItem: LongVideoItem? = null

    constructor(viewType: Int, shortsItemList: List<ShortsItem>) : this(viewType) {
        this.shortsItemList = shortsItemList
    }

    constructor(viewType: Int, longVideoItem: LongVideoItem) : this(viewType) {
        this.longVideoItem = longVideoItem
    }
}

data class ShortsItem(val title: String, val viewsCount: String, val thumbnail: Int)

data class LongVideoItem(
    val title: String,
    val channelLogo: Int,
    val channelName: String,
    val viewsCount: String,
    val uploadDate: String,
    val thumbnail: Int
)
