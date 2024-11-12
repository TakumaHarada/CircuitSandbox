package com.teufelium.circuitsample.screen.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teufelium.circuitsample.entity.Item
import com.teufelium.circuitsample.screen.DetailScreen


@Composable
fun DetailUi(
    state: DetailScreen.State,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text("Detail") },
                navigationIcon = {
                    IconButton(onClick = { state.event(DetailScreen.Event.BackClicked) }) {
                        Icon(Icons.Default.ArrowBackIosNew, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Row {
                    IconImage(
                        url = state.item.icon,
                        modifier = Modifier
                            .padding(16.dp)
                            .width(60.dp)
                            .height(60.dp)
                    )
                    Column {
                        Text(
                            text = state.item.title,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = state.item.description
                        )
                    }
                }

                Text(
                    text = state.item.text
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailUiPreview() {
    DetailUi(
        state = DetailScreen.State(
            item = Item(
                id = "1",
                title = "Title",
                description = "Description",
                text = "Text",
                icon = "https://www.example.com/icon.png"
            ),
            event = {}
        ),
    )
}