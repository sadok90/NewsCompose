package com.sadok.newscompose.di

import android.app.Application
import com.sadok.newscompose.data.manager.LocalUserManagerImpl
import com.sadok.newscompose.domain.manager.LocalUserManager
import com.sadok.newscompose.domain.usecases.app_entry.AppEntryUsesCase
import com.sadok.newscompose.domain.usecases.app_entry.ReadAppEntry
import com.sadok.newscompose.domain.usecases.app_entry.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ) : LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUsesCase(
        localUserManager: LocalUserManager
    ) : AppEntryUsesCase = AppEntryUsesCase(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

}