package com.teufelium.circuitsample.feature.detail

import androidx.compose.runtime.Composable
import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.screen.Screen
import com.teufelium.circuitsample.repository.Repository

class DetailPresenter(
    private val screen: DetailScreen,
    private val navigator: Navigator,
    private val repository: Repository
): Presenter<DetailScreen.State> {
    @Composable
    override fun present(): DetailScreen.State {
        val item = repository.getItem(screen.id)
        return DetailScreen.State(
            item,
            event = { event ->
                when(event) {
                    DetailScreen.Event.BackClicked -> {
                        navigator.pop(result = null)
                    }
                }
            }
        )
    }

    class Factory(private val repository: Repository): Presenter.Factory {
        override fun create(
            screen: Screen,
            navigator: Navigator,
            context: CircuitContext
        ): Presenter<*>? {
            return when(screen) {
                is DetailScreen -> DetailPresenter(screen, navigator, repository)
                else -> null
            }
        }

    }
}