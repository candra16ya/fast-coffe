package com.project.fastcoffe.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.project.fastcoffe.R
import com.project.fastcoffe.activity.FastCoffeDetails
import com.project.fastcoffe.data.AllData

class FastCoffeAdapter(val listFastCoffe: ArrayList<AllData>) :
    RecyclerView.Adapter<FastCoffeAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater
            .from(viewGroup.context)
            .inflate(R.layout.rv_main_activity, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listFastCoffe.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, image, detail) = listFastCoffe[position]
        Glide.with(holder.itemView.context)
            .load(image)
            .apply(RequestOptions())
            .into(holder.adapterImgPhoto)

        holder.adapterName.text = name
        holder.adapterDetail.text = detail


        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener{
            val moveDetails = Intent(mContext, FastCoffeDetails::class.java)
            moveDetails.putExtra(FastCoffeDetails.EXTRA_IMAGE, image)
            moveDetails.putExtra(FastCoffeDetails.EXTRA_DETAIL, detail)
            mContext.startActivity(moveDetails)

        }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var adapterName: TextView = itemView.findViewById(R.id.rv_item_name)
        var adapterDetail: TextView = itemView.findViewById(R.id.rv_item_detail)
        var adapterImgPhoto: ImageView = itemView.findViewById(R.id.rv_img_item)
    }
}
