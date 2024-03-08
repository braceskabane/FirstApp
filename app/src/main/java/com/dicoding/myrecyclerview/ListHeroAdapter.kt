package com.dicoding.myrecyclerview

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ListHeroAdapter(private val listHero: ArrayList<Hero>) : RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(callback: OnItemClickCallback) {
        this.onItemClickCallback = callback
    }
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
        val btnStory: Button = itemView.findViewById(R.id.btn_story)
        val btnTutorial: Button = itemView.findViewById(R.id.btn_tutorial)
        val tvQuotes: TextView = itemView.findViewById(R.id.tv_item_quotes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_hero, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listHero.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val currentHero = listHero[position]

        holder.imgPhoto.setImageResource(currentHero.photo)
        holder.tvName.text = currentHero.name
        holder.tvDescription.text = currentHero.description
        holder.tvQuotes.text = currentHero.quotes
        holder.itemView.setOnClickListener {
            onItemClickCallback?.onItemClicked(listHero[holder.adapterPosition])
        }
        holder.btnStory.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("key_hero", currentHero)
            holder.itemView.context.startActivity(intentDetail)
        }
        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("key_hero", listHero[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
        holder.btnTutorial.setOnClickListener {
            val youtubeUrl = when (currentHero.name) {
                "Cecilion" -> "https://www.youtube.com/watch?v=PtcuzcIfUlI"
                "Carmilla" -> "https://www.youtube.com/watch?v=2D25QO_bhVw"
                "Jhonson" -> "https://www.youtube.com/watch?v=qMSGTOIjQC8"
                "Fanny" -> "https://www.youtube.com/watch?v=APdA3Hh5ksg"
                "Ling" -> "https://www.youtube.com/watch?v=3c2Sm1I5ezE"
                "Yuzhong" -> "https://www.youtube.com/watch?v=Uysf4RHfsGg"
                "Esmeralda" -> "https://www.youtube.com/watch?v=UgqUNMYVHTU"
                "Guinevere" -> "https://www.youtube.com/watch?v=brxjWj9iLGY"
                "Lunox" -> "https://www.youtube.com/watch?v=LkNLpWDLkmg"
                "Kagura" -> "https://www.youtube.com/watch?v=kagura_video_id"
                else -> "https://www.youtube.com/"
            }
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(youtubeUrl))
            holder.itemView.context.startActivity(intent)
        }
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: Hero)
    }
}
