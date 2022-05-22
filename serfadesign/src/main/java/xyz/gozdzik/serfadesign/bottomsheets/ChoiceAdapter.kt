package xyz.gozdzik.serfadesign.bottomsheets

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import xyz.gozdzik.serfadesign.databinding.ItemSingleChoiceBinding

class ChoiceAdapter<T : Enum<T>> :
    ListAdapter<SingleChoiceItem<T>, SingleChoiceViewHolder>(DiffItemCallback()) {

    private var checkedPosition = 0
    val choice: SingleChoiceItem<T>
        get() = getItem(checkedPosition)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleChoiceViewHolder =
        SingleChoiceViewHolder(
            ItemSingleChoiceBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ) { itemPosition ->
            checkedPosition = itemPosition
            notifyDataSetChanged()
        }

    override fun onBindViewHolder(holder: SingleChoiceViewHolder, position: Int) =
        holder.bind(getItem(position), checkedPosition)

    fun setChoiceItems(
        choiceItems: List<SingleChoiceItem<T>>,
        preselectedChoiceItem: SingleChoiceItem<T>?
    ) {
        preselectedChoiceItem?.let { preselectedChoiceItem ->
            checkedPosition = choiceItems.indexOf(preselectedChoiceItem)
        }
        submitList(choiceItems)
    }

    class DiffItemCallback<T : Enum<T>> : DiffUtil.ItemCallback<SingleChoiceItem<T>>() {
        override fun areItemsTheSame(
            oldItem: SingleChoiceItem<T>,
            newItem: SingleChoiceItem<T>
        ): Boolean = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: SingleChoiceItem<T>,
            newItem: SingleChoiceItem<T>
        ): Boolean = oldItem.enum == newItem.enum
    }

}

class SingleChoiceViewHolder(
    private val binding: ItemSingleChoiceBinding,
    private val clickListener: (Int) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    fun <T : Enum<T>> bind(singleChoiceItem: SingleChoiceItem<T>, checkedPosition: Int) {
        binding.item = singleChoiceItem
        binding.rbChoice.isChecked = adapterPosition == checkedPosition
        binding.rbChoice.setOnClickListener {
            clickListener.invoke(adapterPosition)
        }
    }

}