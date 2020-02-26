package com.example.dexter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dexter.models.Pokemon
import kotlinx.android.synthetic.main.item_view.view.*

class PokemonListAdapter(private val listener: (pokemonName: String) -> Unit) :
    RecyclerView.Adapter<PokemonListAdapter.ViewHolder>() {

    private val list = mutableListOf<Pokemon>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_view, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position], listener)
    }

    fun addItems(list: List<Pokemon>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(
            pokemon: Pokemon,
            listener: (pokemonName: String) -> Unit
        ) {
            with(itemView) {
                image.loadUrl(pokemon.spriteUrl)
                title.text = "%s. %s".format(pokemon.id, pokemon.name)
                setOnClickListener { listener.invoke(pokemon.name) }
            }
        }

    }
}
