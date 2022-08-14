package com.gusoft.viewmodelexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModel : ViewModel() {
    var number: Int = 0
    val currentNumber: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>().apply { postValue(number) }
    }

    val currentBoolean: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }


}