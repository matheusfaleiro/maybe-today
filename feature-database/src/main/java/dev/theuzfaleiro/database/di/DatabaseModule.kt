package dev.theuzfaleiro.database.di

import androidx.room.Room
import dev.theuzfaleiro.database.MaybeTodayDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

private const val DATABASE = "MAYBE_TODAY_DATABASE"

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            MaybeTodayDatabase::class.java,
            DATABASE
        ).build()
    }

    single {
        get<MaybeTodayDatabase>().categoryDao()
    }

    single {
        get<MaybeTodayDatabase>().importanceDao()
    }

    single {
        get<MaybeTodayDatabase>().taskDao()
    }

    single {
        get<MaybeTodayDatabase>().urgencyDao()
    }
}
