package id.krisna.viuit.modules.main.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.krisna.viuit.databinding.LayoutMenuItemBinding
import id.krisna.viuit.models.menu.MenuResponse

class HomeAdapter(
    private val context: Context,
    private val itemClick: (data: MenuResponse) -> Unit) : RecyclerView.Adapter<HomeViewHolder>()  {

    private var data: List<MenuResponse> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val itemBinding = LayoutMenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(itemBinding, context, itemClick)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bindData(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun updateData(newData: List<MenuResponse>) {
        this.data = newData
        notifyDataSetChanged()
    }
}