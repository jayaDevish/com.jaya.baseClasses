package com.jaya.bootcamp.learndagger.di.component

import com.jaya.bootcamp.learndagger.di.module.FragmentModule
import com.jaya.bootcamp.learndagger.di.FragmentScope
import com.jaya.bootcamp.learndagger.ui.home.HomeFragment

import dagger.Component

@FragmentScope
@Component(dependencies = [ApplicationComponent::class], modules = [FragmentModule::class])
interface FragmentComponent {

    fun inject(fragment: HomeFragment)
}
