package com.example.fetch

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ItemRepository {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://fetch-hiring.s3.amazonaws.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: ItemService = retrofit.create(ItemService::class.java)

    suspend fun fetchItems(): Map<Int, List<Item>> {
        // Fetching items from the API
        val fetchedItems = service.getItems()

        // Filtering out items where the name is blank or null
        val filteredItems = fetchedItems.filter { !it.name.isNullOrBlank() }

        // Sorting items by listId and name
        val sortedItems = filteredItems.sortedWith(compareBy({ it.listId }, { it.name }))

        // Grouping items by listId
        return sortedItems.groupBy { it.listId }
    }
}
