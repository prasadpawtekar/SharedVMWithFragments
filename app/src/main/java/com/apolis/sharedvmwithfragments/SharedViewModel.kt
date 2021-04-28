package com.apolis.sharedvmwithfragments

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class SharedViewModel: ViewModel() {
    val num = MutableLiveData<Int>(0)
    val msg = MutableLiveData<String>("")

    fun generateNext() {
        val i = Random.nextInt(500)
        num.postValue(i)
    }

}