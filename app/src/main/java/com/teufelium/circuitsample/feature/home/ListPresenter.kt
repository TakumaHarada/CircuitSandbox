package com.teufelium.circuitsample.feature.home

import androidx.compose.runtime.Composable
import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.screen.Screen
import com.teufelium.circuitsample.repository.Repository
import com.teufelium.circuitsample.feature.detail.DetailScreen

class ListPresenter(
    private val navigator: Navigator,
    private val repository: Repository
): Presenter<ListScreen.State> {
    @Composable
    override fun present(): ListScreen.State {
        val items = repository.getItems()

        return ListScreen.State(
            items = items
        ) { event ->
            when(event) {
                is ListScreen.Event.ItemClicked -> {
                    navigator.goTo(DetailScreen(event.id))
                }
            }
        }
    }

    class Factory(private val repository: Repository): Presenter.Factory {
        override fun create(
            screen: Screen,
            navigator: Navigator,
            context: CircuitContext
        ): Presenter<*>? {
            return when(screen) {
                is ListScreen -> ListPresenter(navigator, repository)
                else -> null
            }
        }
    }
}