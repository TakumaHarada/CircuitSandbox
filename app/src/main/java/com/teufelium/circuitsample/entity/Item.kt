package com.teufelium.circuitsample.entity

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.LinkAnnotation

@Immutable
class Item (
    val id: String,
    val title: String,
    val description: String,
    val text: String,
    val icon: String
)