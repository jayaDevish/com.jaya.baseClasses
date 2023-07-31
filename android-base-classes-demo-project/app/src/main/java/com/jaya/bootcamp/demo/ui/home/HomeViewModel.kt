package com.jaya.bootcamp.demo.ui.home

import androidx.lifecycle.MutableLiveData
import com.jaya.bootcamp.demo.data.local.DatabaseService
import com.jaya.bootcamp.demo.data.remote.NetworkService
import com.jaya.bootcamp.demo.ui.base.BaseViewModel
import com.jaya.bootcamp.demo.utils.NetworkHelper
import io.reactivex.disposables.CompositeDisposable

class HomeViewModel constructor(
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        private val databaseService: DatabaseService,
        private val networkService: NetworkService)
    : BaseViewModel(compositeDisposable, networkHelper) {

    val testData = MutableLiveData<String>()

    override fun onCreate() {
        testData.postValue("Hello from MainViewModel")
    }
}
