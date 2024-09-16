package com.example.fetch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fetch.databinding.ListItemBinding

class GroupedItemAdapter : RecyclerView.Adapter<GroupedItemAdapter.GroupedItemViewHolder>() {

    private var groupedItemList: Map<Int, List<Item>> = emptyMap()

    // Updating the grouped list of items
    fun submitGroupedList(list: Map<Int, List<Item>>) {
        groupedItemList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupedItemViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GroupedItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GroupedItemViewHolder, position: Int) {
        val listId = groupedItemList.keys.toList()[position]
        val items = groupedItemList[listId]
        holder.bind(listId, items)
    }

    override fun getItemCount(): Int = groupedItemList.size

    class GroupedItemViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(listId: Int?, items: List<Item>?) {
            // Displaying the ListId
            binding.textView.text = "ListId: $listId\n"
            // Displaying the items for the current ListId
            items?.forEach { item ->
                binding.textView.append("${item.name}\n")
            }
        }
    }
}
