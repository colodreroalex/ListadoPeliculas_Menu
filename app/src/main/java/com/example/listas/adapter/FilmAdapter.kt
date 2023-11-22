package com.example.listas.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listas.Film
import com.example.listas.R

class FilmAdapter(var filmList: List<Film>): RecyclerView.Adapter<FilmViewHolder>() {

    // se va a llamar cuando el RecyclerView requiera de una nueva vista
    // para mostrar algo en pantalla porque no existan vistas que podamos reciclar.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return FilmViewHolder(layoutInflater.inflate(R.layout.item_film, parent, false))
    }

    //se va a llamar siempre que necesitemos actualizar los datos de una vista,
    // independiente de si esta se ha creado por primera vez o se está reciclando,
    // porque ha salido por pantalla y la podemos volver a usar
    override fun getItemCount(): Int {
        return filmList.size
    }

    // para dibujar la lista de elementos de la pantalla, el RecyclerView
    // pedirá al adaptador el número total de elementos que contiene la lista.
    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val item = filmList[position]
        holder.render(item)

    }


    fun actualizarPelis(listaPelis: List<Film>) {
        this.filmList = listaPelis
        notifyDataSetChanged()
    }
}