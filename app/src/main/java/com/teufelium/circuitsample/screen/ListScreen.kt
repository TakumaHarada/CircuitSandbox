package com.teufelium.circuitsample.screen

import com.slack.circuit.runtime.CircuitUiEvent
import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.screen.Screen
import com.teufelium.circuitsample.entity.Item
import kotlinx.parcelize.Parcelize

@Parcelize
data object ListScreen : Screen {
    data class State(
        val items: List<Item>,
        val event: (Event) -> Unit
    ): CircuitUiState

    sealed class Event: CircuitUiEvent {
        data class ItemClicked(val id: String): Event()
    }
}