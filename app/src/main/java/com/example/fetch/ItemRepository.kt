package com.example.fetch

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ItemRepository {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://fetch-hiring.s3.amazonaws.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: ItemService = retrofit.create(ItemService::class.java)

    // Fetching items from the API and returning them grouped by listId
    suspend fun fetchItems(): Map<Int, List<Item>> {
        // Fetch the items from the API
        val fetchedItems = service.getItems()

        // Filter, sort, and group the items
        val sortedItems = fetchedItems
            .filter { !it.name.isNullOrBlank() } // Filter out items where the name is blank or null
            .sortedWith(compareBy({ it.listId }, { extractNumber(it.name) })) // Sort by listId and name

        // Group the sorted items by listId
        return sortedItems.groupBy { it.listId }
    }

    // Helper function to extract the numeric part of the name
    private fun extractNumber(name: String?): Int {
        return name?.filter { it.isDigit() }?.toIntOrNull() ?: 0
    }
}
