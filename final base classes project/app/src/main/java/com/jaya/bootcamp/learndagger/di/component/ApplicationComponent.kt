package com.jaya.bootcamp.learndagger.di.component

import android.content.Context
import com.jaya.bootcamp.learndagger.MyApplication
import com.jaya.bootcamp.learndagger.data.local.DatabaseService
import com.jaya.bootcamp.learndagger.data.remote.NetworkService
import com.jaya.bootcamp.learndagger.di.ApplicationContext
import com.jaya.bootcamp.learndagger.di.module.ApplicationModule
import com.jaya.bootcamp.learndagger.utils.NetworkHelper
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: MyApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkService

    fun getDatabaseService(): DatabaseService

    fun getNetworkHelper(): NetworkHelper
}
