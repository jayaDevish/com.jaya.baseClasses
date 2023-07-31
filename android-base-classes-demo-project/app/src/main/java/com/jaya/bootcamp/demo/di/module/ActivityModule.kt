package com.jaya.bootcamp.demo.di.module

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import com.jaya.bootcamp.demo.data.local.DatabaseService
import com.jaya.bootcamp.demo.data.remote.NetworkService
import com.jaya.bootcamp.demo.di.ActivityContext
import com.jaya.bootcamp.demo.ui.base.BaseActivity
import com.jaya.bootcamp.demo.ui.main.MainViewModel
import com.jaya.bootcamp.demo.utils.NetworkHelper
import com.jaya.bootcamp.demo.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @ActivityContext
    @Provides
    fun provideContext(): Context = activity

    @Provides
    fun provideMainViewModel(
            compositeDisposable: CompositeDisposable,
            networkHelper: NetworkHelper,
            databaseService: DatabaseService,
            networkService: NetworkService
    ): MainViewModel = ViewModelProviders.of(
            activity, ViewModelProviderFactory(MainViewModel::class) {
        MainViewModel(compositeDisposable, networkHelper, databaseService, networkService)
    }).get(MainViewModel::class.java)
}
