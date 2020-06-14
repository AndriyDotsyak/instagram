package com.instagram.di.module

import com.instagram.screen.home.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeHomeActivity(): HomeActivity
}