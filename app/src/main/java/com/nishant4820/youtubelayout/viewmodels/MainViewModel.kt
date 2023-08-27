package com.nishant4820.youtubelayout.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nishant4820.youtubelayout.data.DataItem
import com.nishant4820.youtubelayout.repositories.MockDataRepository

class MainViewModel : ViewModel() {
    private val repository = MockDataRepository()
    val dataList = MutableLiveData<ArrayList<DataItem>>()

    fun getMockData() {
        dataList.postValue(repository.getMockData())
    }
}