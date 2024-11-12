package com.teufelium.circuitsample

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.slack.circuit.backstack.rememberSaveableBackStack
import com.slack.circuit.foundation.Circuit
import com.slack.circuit.foundation.CircuitCompositionLocals
import com.slack.circuit.foundation.CircuitContent
import com.slack.circuit.foundation.NavigableCircuitContent
import com.slack.circuit.foundation.rememberCircuitNavigator
import com.teufelium.circuitsample.screen.ListScreen
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val circuit: Circuit by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val backStack = rememberSaveableBackStack(root = ListScreen)
            val navigator = rememberCircuitNavigator(backStack = backStack)

            CircuitCompositionLocals(circuit) {
                NavigableCircuitContent(
                    navigator = navigator,
                    backStack = backStack
                )
            }
        }
    }
}