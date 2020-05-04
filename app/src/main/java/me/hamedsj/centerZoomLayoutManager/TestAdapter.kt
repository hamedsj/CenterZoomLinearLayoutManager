package me.hamedsj.centerZoomLayoutManager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_recycler.view.*
import me.hamedsj.centerZoomLayoutManager.databinding.ItemRecyclerBinding

class TestAdapter constructor(private var items: List<RecyclerViewItem>):
    RecyclerView.Adapter<TestAdapter.RowViewHolder>() {
    class RowViewHolder (binding: ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root){
        init {

        }
    }

    private lateinit var binding:ItemRecyclerBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowViewHolder {
        binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RowViewHolder, position: Int) {
        ViewCompat.setBackground(holder.itemView.recyclerItemRoot,items[position].bg)
    }

    override fun getItemCount(): Int {
        return items.size
    }

}