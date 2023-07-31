package com.jaya.bootcamp.learndagger.ui.home

import com.jaya.bootcamp.learndagger.data.local.DatabaseService
import com.jaya.bootcamp.learndagger.data.remote.NetworkService
import com.jaya.bootcamp.learndagger.di.FragmentScope
import com.jaya.bootcamp.learndagger.utils.NetworkHelper

import javax.inject.Inject

@FragmentScope
class HomeViewModel @Inject constructor(
        private val databaseService: DatabaseService,
        private val networkService: NetworkService,
        private val networkHelper: NetworkHelper) {

    val someData: String
        get() = (databaseService.dummyData
                + " : " + networkService.dummyData
                + " : " + networkHelper.isNetworkConnected)
}
