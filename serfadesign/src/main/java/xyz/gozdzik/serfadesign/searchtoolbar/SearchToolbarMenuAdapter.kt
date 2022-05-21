package xyz.gozdzik.serfadesign.searchtoolbar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import xyz.gozdzik.serfadesign.databinding.ItemSearchToolbarMenuBinding

class SearchToolbarMenuAdapter<T : Enum<T>>(private val clickListener: (T: Enum<T>) -> Unit) :
    ListAdapter<SearchToolbarMenuItem<T>, SearchToolbarMenuViewHolder>(DiffItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchToolbarMenuViewHolder =
        SearchToolbarMenuViewHolder(
            ItemSearchToolbarMenuBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ) { itemPosition ->
            clickListener.invoke(getItem(itemPosition).enum)
        }

    override fun onBindViewHolder(holder: SearchToolbarMenuViewHolder, position: Int) =
        holder.bind(getItem(position))

    class DiffItemCallback<T : Enum<T>> : DiffUtil.ItemCallback<SearchToolbarMenuItem<T>>() {
        override fun areItemsTheSame(
            oldItem: SearchToolbarMenuItem<T>,
            newItem: SearchToolbarMenuItem<T>
        ): Boolean = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: SearchToolbarMenuItem<T>,
            newItem: SearchToolbarMenuItem<T>
        ): Boolean = oldItem.enum == newItem.enum
    }

}

class SearchToolbarMenuViewHolder(
    private val binding: ItemSearchToolbarMenuBinding,
    private val clickListener: (Int) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener {
            clickListener.invoke(adapterPosition)
        }
    }

    fun <T : Enum<T>> bind(searchToolbarMenuItem: SearchToolbarMenuItem<T>) {
        binding.item = searchToolbarMenuItem
    }

}