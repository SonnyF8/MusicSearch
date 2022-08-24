package com.code.musicsearch.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.code.musicsearch.R
import com.code.musicsearch.SongData
import com.code.musicsearch.databinding.SongRowBinding

class SongAdapter(val songData: SongData?):
    RecyclerView.Adapter<SongAdapter.SongViewHolder>() {

    var context: Context? = null

    class SongViewHolder(val binding: SongRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        context = parent.context

        return SongViewHolder(SongRowBinding.inflate(
                LayoutInflater.from(context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        Glide.with(context!!)
            .load(songData?.results?.get(position)?.artworkUrl60)
            .placeholder(R.drawable.hourglass_black_24dp)
            .fitCenter().into(holder.binding.thumbnail)

        holder.binding.term.text = songData?.results?.get(position)?.artistName
        holder.binding.trackName.text = songData?.results?.get(position)?.trackName
        holder.binding.collection.text = songData?.results?.get(position)?.collectionName
    }

    override fun getItemCount(): Int {
        return songData?.results!!.size
    }
}
