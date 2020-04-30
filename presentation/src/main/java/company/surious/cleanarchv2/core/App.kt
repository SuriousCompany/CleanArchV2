package company.surious.cleanarchv2.core

import android.app.Application
import company.surious.cleanarchv2.viewModelsModule
import company.surious.data.repositoriesModule
import company.surious.domain.useCasesModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(repositoriesModule, viewModelsModule, useCasesModule)
        }
    }
}