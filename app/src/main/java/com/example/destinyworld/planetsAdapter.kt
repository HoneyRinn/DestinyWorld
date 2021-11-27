package com.example.destinyworld

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class planetsAdapter (val context: Context, val list: ArrayList<planets>): RecyclerView.Adapter<planetsAdapter.MyVh>() {

        class MyVh (itemView: View): RecyclerView.ViewHolder(itemView) {
                val title: TextView = itemView.findViewById(R.id.title_planet)
                val desc: TextView = itemView.findViewById(R.id.text_planet)
                val image: ImageView = itemView.findViewById(R.id.img_planets)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVh {
                val root = LayoutInflater.from(context).inflate(R.layout.skid_planets,parent,false)
                return MyVh(root)
        }

        override fun onBindViewHolder(holder: MyVh, position: Int) {
                holder.title.text=list[position].title
                holder.desc.text=list[position].text
                holder.image.setImageResource(list[position].image)
        }

        override fun getItemCount(): Int {
                return list.size
        }

}