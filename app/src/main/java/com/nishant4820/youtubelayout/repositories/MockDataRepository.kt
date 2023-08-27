package com.nishant4820.youtubelayout.repositories

import com.nishant4820.youtubelayout.R
import com.nishant4820.youtubelayout.data.*

class MockDataRepository {

    fun getMockData(): ArrayList<DataItem> {
        return prepareMockData()
    }

    private fun prepareMockData(): ArrayList<DataItem> {
        val mockData = ArrayList<DataItem>()

        val longVideoItem1 = LongVideoItem(
            "CHANDRAYAAN-3 MAKE WORLD RECORD, ISRO'S LIVE BREAK RECORD |PAKISTAN PUBLIC REACTION ON CHANDRAYAAN-3",
            R.drawable.long_cl_3,
            "Real entertainment tv",
            "3.8M",
            "25 Aug 2023",
            R.drawable.long_th_3
        )
        val longVideoItem2 = LongVideoItem(
            "Hyundai CRETA Production - India, Chennai Plant",
            R.drawable.long_cl_4,
            "KondorCars",
            "1.4M",
            "31 Dec 2022",
            R.drawable.long_th_4
        )
        val longVideoItem3 = LongVideoItem(
            "My New Youtube Office Tour \uD83D\uDE0D",
            R.drawable.long_cl_5,
            "Indian Backpacker",
            "277K",
            "18 Dec 2022",
            R.drawable.long_th_5
        )
        val longVideoItem4 = LongVideoItem(
            "REALITY EXPOSED OF BUYING LARGE SIZE SUV CARS IN INDIA",
            R.drawable.long_cl_1,
            "Mycarhelpline.com",
            "19K",
            "28 Aug 2023",
            R.drawable.long_th_1
        )

        val longVideoItem5 = LongVideoItem(
            "Only 0.0005% Lucky People Can Complete This IMPOSSIBLE Car Parkour Race in GTA 5",
            R.drawable.long_cl_2,
            "THE CASETOO",
            "103K",
            "26 Aug 2023",
            R.drawable.long_th_2
        )

        val shortsItem1 = ShortsItem(
            "RBI is Giving out FREE MONEY!! \uD83D\uDCB8 #LLAShorts 698",
            "268K",
            R.drawable.shorts_th_1
        )
        val shortsItem2 = ShortsItem(
            "Why Hyundai's Are Getting Ugly? \uD83E\uDD2E #shorts #short #shortsvideo #shortsfeed #shortsyoutube #hyundai",
            "277K",
            R.drawable.shorts_th_2
        )
        val shortsItem3 = ShortsItem(
            "Change in my Attitude after wearing Gold Ring \uD83E\uDD34\uD83C\uDFFB #shorts",
            "428K",
            R.drawable.shorts_th_3
        )
        val shortsItem4 = ShortsItem(
            "❌ 18 inche alloy wheels Hyundai Exter\uD83D\uDD25 Exter modified 2023\uD83D\uDD25Exter modification 2023\uD83D\uDD25first in india",
            "1.3M",
            R.drawable.shorts_th_4
        )
        val shortsItemList = ArrayList<ShortsItem>()
        shortsItemList.add(shortsItem1)
        shortsItemList.add(shortsItem2)
        shortsItemList.add(shortsItem3)
        shortsItemList.add(shortsItem4)

        mockData.add(DataItem(DataItemType.LONG_VIDEO, longVideoItem1))
        mockData.add(DataItem(DataItemType.SHORTS, shortsItemList))
        mockData.add(DataItem(DataItemType.LONG_VIDEO, longVideoItem2))
        mockData.add(DataItem(DataItemType.LONG_VIDEO, longVideoItem3))
        mockData.add(DataItem(DataItemType.LONG_VIDEO, longVideoItem4))
        mockData.add(DataItem(DataItemType.SHORTS, shortsItemList.reversed()))
        mockData.add(DataItem(DataItemType.LONG_VIDEO, longVideoItem5))

        return mockData
    }
}