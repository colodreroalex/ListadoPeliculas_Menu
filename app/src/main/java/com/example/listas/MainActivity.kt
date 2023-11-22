package com.example.listas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listas.adapter.FilmAdapter
import com.example.listas.databinding.ActivityMainBinding

class MainActivity : ActivityWithMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.filtro.setOnClickListener{
            binding.filtro.isVisible = true
        }

        //DECORAR LAS LISTAS - Cambiamos a GridLayoutManager
        val decoration = DividerItemDecoration(this, GridLayoutManager.VERTICAL)

        //Creamos el manager
        //val manager = GridLayoutManager(this, 2)


        binding.recycler.layoutManager = LinearLayoutManager(this)
        //binding.recycler.layoutManager = manager
        binding.recycler.adapter = FilmAdapter(FilmProvider.films)
        //Añadir decoracion
        binding.recycler.addItemDecoration(decoration)


        val adapter = FilmAdapter(FilmProvider.films)
        binding.recycler.adapter = adapter

        //Damos funcionalidad al filtro
        //Filtrado por nombre de parque - Crear funcion en ParkAdapter
        binding.filtro.addTextChangedListener {filtro ->
            val filtroPelicula = FilmProvider.films.filter { film ->
                film.film.lowercase().contains(filtro.toString())
            }
            adapter.actualizarPelis(filtroPelicula)
        }




    }
}