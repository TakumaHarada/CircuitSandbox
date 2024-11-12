package com.teufelium.circuitsample.screen.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.teufelium.circuitsample.screen.ListScreen
import com.teufelium.circuitsample.entity.Item

@Composable
fun ListUi(
    state: ListScreen.State,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text("Items") }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding)
        )
        {
            items(state.items) { item ->
                NewsItem(
                    item = item,
                    onClick = {
                        state.event(ListScreen.Event.ItemClicked(item.id))
                    }
                )
            }
        }
    }
}

@Composable
private fun NewsItem(
    item: Item,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(16.dp)
            .clickable { onClick() }
    ) {
        IconImage(
            url = item.icon,
            modifier = Modifier
                .width(60.dp)
                .height(60.dp)
        )
        Spacer(modifier = modifier.width(16.dp))
        Column {
            Text(
                text = item.title,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = modifier.height(4.dp))
            Text(text = item.description)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NewsItemPreview() {
    NewsItem(
        item = Item(
            id = "1",
            title = "Title",
            description = "Description",
            text = "Text",
            icon = "https://picsum.photos/seed/picture/60"
        )
    )
}