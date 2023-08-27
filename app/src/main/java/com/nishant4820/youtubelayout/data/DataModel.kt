package com.nishant4820.youtubelayout.data

// Class defining the type of DataItem
class DataItemType {
    companion object {
        const val LONG_VIDEO = 0
        const val SHORTS = 1
    }
}

// Data class to store DataItem
data class DataItem(val viewType: Int) {

    var shortsItemList: List<ShortsItem>? = null
    var longVideoItem: LongVideoItem? = null

    // Secondary constructor to initialise Shorts Video Items
    constructor(viewType: Int, shortsItemList: List<ShortsItem>) : this(viewType) {
        this.shortsItemList = shortsItemList
    }

    // Secondary constructor to initialise Long Video Items
    constructor(viewType: Int, longVideoItem: LongVideoItem) : this(viewType) {
        this.longVideoItem = longVideoItem
    }
}

// Data class defining the parameters of ShortsItem
data class ShortsItem(val title: String, val viewsCount: String, val thumbnail: Int)

// Data class defining the parameters of LongVideoItem
data class LongVideoItem(
    val title: String,
    val channelLogo: Int,
    val channelName: String,
    val viewsCount: String,
    val uploadDate: String,
    val thumbnail: Int
)
