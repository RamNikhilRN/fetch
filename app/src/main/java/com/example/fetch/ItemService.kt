package com.example.fetch

import retrofit2.http.GET

interface ItemService {
    @GET("hiring.json")
    suspend fun getItems(): List<Item>
}