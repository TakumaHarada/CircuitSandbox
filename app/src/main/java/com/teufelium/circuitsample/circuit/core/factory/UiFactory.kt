package com.teufelium.circuitsample.circuit.core.factory

import com.slack.circuit.runtime.CircuitContext
import com.slack.circuit.runtime.screen.Screen
import com.slack.circuit.runtime.ui.Ui
import com.slack.circuit.runtime.ui.ui
import com.teufelium.circuitsample.feature.detail.DetailScreen
import com.teufelium.circuitsample.feature.home.ListScreen
import com.teufelium.circuitsample.feature.detail.DetailUi
import com.teufelium.circuitsample.feature.home.ListUi

class UiFactory: Ui.Factory {
    override fun create(
        screen: Screen,
        context: CircuitContext
    ): Ui<*>? {
        return when(screen) {
            is ListScreen -> ui<ListScreen.State> { state, modifier ->
                ListUi(state = state, modifier = modifier)
            }
            is DetailScreen -> ui<DetailScreen.State> { state, modifier ->
                DetailUi(state = state, modifier = modifier)
            }
            else -> null
        }
    }
}