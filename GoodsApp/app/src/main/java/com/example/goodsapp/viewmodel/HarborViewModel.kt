package com.example.goodsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HarborViewModel : ViewModel() {
    private val _shipInfo = MutableLiveData<String>()
    val shipInfo: LiveData<String>
        get() = _shipInfo

    private val _tunnelInfo = MutableLiveData<String>()
    val tunnelInfo: LiveData<String>
        get() = _tunnelInfo

    private val _goodsInfo = MutableLiveData<String>()
    val goodsInfo: LiveData<String>
        get() = _goodsInfo

    fun updateShipInfo(info: String) {
        _shipInfo.postValue(info)
    }

    fun updateTunnelInfo(info: String) {
        _tunnelInfo.postValue(info)
    }

    fun updateGoodsInfo(info: String) {
        _goodsInfo.postValue(info)
    }
}
