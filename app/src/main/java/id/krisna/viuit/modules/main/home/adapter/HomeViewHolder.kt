package id.krisna.viuit.modules.main.home.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import id.krisna.viuit.databinding.LayoutMenuItemBinding
import id.krisna.viuit.models.menu.MenuResponse

class HomeViewHolder (
    private val itemBinding: LayoutMenuItemBinding,
    private val context: Context,
    private val itemClick: (data: MenuResponse) -> Unit
) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bindData(data: MenuResponse){

    }
}