package com.teufelium.circuitsample.repository

import com.teufelium.circuitsample.entity.Item

interface Repository {
    fun getItems(): List<Item>
    fun getItem(id: String): Item
}

class RepositoryImpl: Repository {
    override fun getItems(): List<Item> {
        return listOf(
            Item(
                id = "1",
                title = "Title 1",
                description = "Description 1",
                text = "Text 1",
                icon = "https://picsum.photos/seed/1/60"
            ),
            Item(
                id = "2",
                title = "Title 2",
                description = "Description 2",
                text = "Text 2",
                icon = "https://picsum.photos/seed/2/60"
            ),
            Item(
                id = "3",
                title = "Title 3",
                description = "Description 3",
                text = "Text 3",
                icon = "https://picsum.photos/seed/3/60"
            )
        )
    }

    override fun getItem(id: String): Item {
        return Item(
            id = id,
            title = "Title $id",
            description = "Description $id",
            text = "Text $id",
            icon = "https://picsum.photos/seed/$id/60"
        )
    }

}