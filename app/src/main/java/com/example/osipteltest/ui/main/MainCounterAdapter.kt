package com.example.osipteltest.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.osipteltest.core.BaseViewHolder
import com.example.osipteltest.data.model.Counter
import com.example.osipteltest.databinding.ItemRvMainCounterBinding


class MainCounterAdapter(
    private val list: MutableList<Counter>,
    private val itemClickListener: CounterListClickListener
//    ,
//    private val itemCounterSwipeListener: CounterSwipeListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface CounterListClickListener {
        fun listItemClicked(counter: Counter)

        fun listItemLongClicked(counter: Counter)
    }

//    interface CounterSwipeListener {
//        fun counterSwipe(counter: Counter)
//    }

//    fun deleteCounterSwipe(position: Int){
//        itemCounterSwipeListener.counterSwipe(list[position])
//        list.removeAt(position)
//        notifyDataSetChanged()
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =
            ItemRvMainCounterBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        val holder = CounterViewHolder(itemBinding, parent.context)

        itemBinding.root.setOnClickListener {
            val position =
                holder.adapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION }
                    ?: return@setOnClickListener

            itemClickListener.listItemClicked(list[position])
        }

        itemBinding.root.setOnLongClickListener {
            val pos = holder.adapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION } ?: return@setOnLongClickListener true

            itemClickListener.listItemLongClicked(list[pos])

            return@setOnLongClickListener true
        }
        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is CounterViewHolder -> holder.bind(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

//    fun addList(counter: Counter) {
//        list.add(counter)
//        notifyItemInserted(list.size-1)
//    }

    private inner class CounterViewHolder(
        val binding: ItemRvMainCounterBinding,
        val context: Context
    ) : BaseViewHolder<Counter>(binding.root) {
        override fun bind(item: Counter): Unit = with(binding) {
            txtTitleCount.text = item.title
            txtNumCounter.text = item.count.toString()
        }

    }

}

//class MainCounterViewHolder(view: View): RecyclerView.ViewHolder(view) {
//
////    val txtTitle = view.txt_title_count
////    var txtCount = view.txt_num_counter
//}