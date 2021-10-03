package uz.eposystems.bfahackathon.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.eposystems.bfahackathon.network.ApiClient
import uz.eposystems.bfahackathon.network.ApiInterface
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    @Singleton
    fun provideApiService(@ApplicationContext context: Context): ApiInterface = ApiClient(context).retrofitService()

}