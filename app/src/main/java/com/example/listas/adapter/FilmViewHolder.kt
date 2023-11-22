package com.example.listas.adapter

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.listas.Film
import com.example.listas.databinding.ItemFilmBinding

class FilmViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val binding = ItemFilmBinding.bind(view)

    fun render(filmModel: Film){
        binding.FilmName.text=filmModel.film
        binding.FilmDirector.text=filmModel.director
        binding.FilmYear.text=filmModel.año.toString()

        //ACCEDER A LA IMG
        Glide.with(binding.FilmPhoto.context).load(filmModel.photo).into(binding.FilmPhoto)

        //CONTROLAR DONDE SE HACE CLICK
        binding.FilmPhoto.setOnClickListener{
            Toast.makeText(binding.FilmPhoto.context, filmModel.film, Toast.LENGTH_SHORT).show()
        }

        //Evento para hacer click en cualquier sitio de la lista de cada pelicula
        itemView.setOnClickListener{
            Toast.makeText(binding.FilmPhoto.context, filmModel.director, Toast.LENGTH_SHORT).show()
        }

    }
}