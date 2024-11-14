package com.teufelium.circuitsample.feature.detail

import com.slack.circuit.runtime.CircuitUiEvent
import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.screen.Screen
import com.teufelium.circuitsample.entity.Item
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailScreen(
    val id: String
) : Screen{
    data class State(
        val item: Item,
        val event: (Event) -> Unit
    ): CircuitUiState

    sealed class Event: CircuitUiEvent {
        data object BackClicked: Event()
    }

}