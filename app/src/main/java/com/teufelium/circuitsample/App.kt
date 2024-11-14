package com.teufelium.circuitsample

import android.app.Application
import com.slack.circuit.foundation.Circuit
import com.teufelium.circuitsample.circuit.core.factory.PresenterFactory
import com.teufelium.circuitsample.circuit.core.factory.UiFactory
import com.teufelium.circuitsample.repository.Repository
import com.teufelium.circuitsample.repository.RepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@App)
            modules(modules)
        }
    }
}

val modules = module {
    single<Repository> {
        RepositoryImpl()
    }

    single<Circuit> {
        Circuit.Builder()
            .addPresenterFactory(PresenterFactory(get()))
            .addUiFactory(UiFactory())
            .build()
    }
}