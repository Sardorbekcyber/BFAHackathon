package uz.eposystems.bfahackathon.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.eposystems.bfahackathon.db.NiatDB
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): NiatDB {
        return Room
            .databaseBuilder(context, NiatDB::class.java, "uz.turbosoft.niat")
            .fallbackToDestructiveMigration()
            .build()
    }

}