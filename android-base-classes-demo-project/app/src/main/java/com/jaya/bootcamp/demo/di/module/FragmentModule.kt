package com.jaya.bootcamp.demo.di.module

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import com.jaya.bootcamp.demo.data.local.DatabaseService
import com.jaya.bootcamp.demo.data.remote.NetworkService
import com.jaya.bootcamp.demo.di.ActivityContext
import com.jaya.bootcamp.demo.ui.base.BaseFragment
import com.jaya.bootcamp.demo.ui.home.HomeViewModel
import com.jaya.bootcamp.demo.utils.NetworkHelper
import com.jaya.bootcamp.demo.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class FragmentModule(private val fragment: BaseFragment<*>) {

    @ActivityContext
    @Provides
    fun provideContext(): Context = fragment.context!!

    @Provides
    fun provideMainViewModel(
            compositeDisposable: CompositeDisposable,
            networkHelper: NetworkHelper,
            databaseService: DatabaseService,
            networkService: NetworkService
    ): HomeViewModel = ViewModelProviders.of(
            fragment, ViewModelProviderFactory(HomeViewModel::class) {
        HomeViewModel(compositeDisposable, networkHelper, databaseService, networkService)
    }).get(HomeViewModel::class.java)
}
