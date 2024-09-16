package com.example.fetch


import androidx.lifecycle.*
import kotlinx.coroutines.launch

class ItemViewModel : ViewModel() {
    private val itemRepository = ItemRepository()

    private val _groupedItems = MutableLiveData<Map<Int, List<Item>>>()
    val groupedItems: LiveData<Map<Int, List<Item>>> get() = _groupedItems

    // Function to load items asynchronously using a coroutine
    fun loadItems() {
        viewModelScope.launch {
            val fetchedItems = itemRepository.fetchItems()
            _groupedItems.value = fetchedItems
        }
    }
}