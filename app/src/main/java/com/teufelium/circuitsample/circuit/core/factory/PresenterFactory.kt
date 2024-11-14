package com.teufelium.circuitsample.circuit.core.factory

import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.screen.Screen
import com.teufelium.circuitsample.repository.Repository
import com.teufelium.circuitsample.feature.detail.DetailScreen
import com.teufelium.circuitsample.feature.home.ListScreen
import com.teufelium.circuitsample.feature.detail.DetailPresenter
import com.teufelium.circuitsample.feature.home.ListPresenter

class PresenterFactory(
    private val repository: Repository
)
    : Presenter.Factory {
    override fun create(
        screen: Screen,
        navigator: Navigator,
        context: CircuitContext
    ): Presenter<*>? {
        return when(screen) {
            is ListScreen -> ListPresenter(navigator, repository)
            is DetailScreen -> DetailPresenter(screen, navigator, repository)
            else -> null
        }
    }
}