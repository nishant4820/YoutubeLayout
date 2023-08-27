package com.nishant4820.youtubelayout.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nishant4820.youtubelayout.data.DataItem
import com.nishant4820.youtubelayout.repositories.MockDataRepository

// ViewModel to link Data Model and Views (Fragment)
class MainViewModel : ViewModel() {

    // Creating an Instance of Mock Repository
    private val repository = MockDataRepository()
    val dataList = MutableLiveData<ArrayList<DataItem>>()

    fun getMockData() {
        dataList.postValue(repository.getMockData())
    }
}