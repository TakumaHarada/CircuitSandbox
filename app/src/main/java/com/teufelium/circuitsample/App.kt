package com.teufelium.circuitsample

import android.app.Application
import com.slack.circuit.foundation.Circuit
import com.teufelium.circuitsample.screen.DetailScreen
import com.teufelium.circuitsample.screen.presenter.ListPresenter
import com.teufelium.circuitsample.screen.ListScreen
import com.teufelium.circuitsample.screen.presenter.DetailPresenter
import com.teufelium.circuitsample.screen.ui.DetailUi
import com.teufelium.circuitsample.screen.ui.ListUi
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
            .addPresenterFactory(ListPresenter.Factory(get()))
            .addPresenterFactory(DetailPresenter.Factory(get()))
            .addUi<ListScreen, ListScreen.State> { state, modifier ->
                ListUi(state, modifier)
            }
            .addUi<DetailScreen, DetailScreen.State> { state, modifier ->
                DetailUi(state, modifier)
            }
            .build()
    }
}