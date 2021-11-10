package dev.theuzfaleiro.maybetoday.application

import android.app.Application
import dev.theuzfaleiro.database.di.databaseModule
import dev.theuzfaleiro.maybetoday.di.taskModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MaybeTodayApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()

            androidContext(this@MaybeTodayApplication)

            androidFileProperties()

            modules(databaseModule, taskModule)
        }
    }
}
