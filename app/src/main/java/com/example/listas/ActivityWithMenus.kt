package com.example.listas

import android.content.Intent
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

open class ActivityWithMenus: AppCompatActivity() {
    companion object{
        var actividadActual = 0
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        //RELACIONAMOS LA CLASS CON EL LAYOUT QUE HEMOS CREADO
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_principal, menu)

        //DESACTIVAR LA OPCION DE LA ACTIVIDAD EN LA QUE YA NO ESTAMOS
        for(i in 0 until  menu.size()) {
            menu.getItem(i).isEnabled = i != actividadActual
        }

        // Condición para hacer visible o invisible el ícono de búsqueda
        val itemBuscar = menu.findItem(R.id.buscar)
        itemBuscar.isVisible = actividadActual == 0  // Cambia el índice según sea necesario
        return true
    }




    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){

            R.id.salir -> {
                AlertDialog.Builder(this)  // Crea un diálogo de alerta utilizando el contexto actual
                    .setTitle("Confirmacion")  // Establece el título del diálogo
                    .setMessage("¿Desea cerrar la aplicación?")  // Establece el mensaje del diálogo
                    .setCancelable(false)  // Evita que se pueda cancelar el diálogo tocando fuera de él
                    .setPositiveButton(android.R.string.ok, { dialog, which ->
                        // Cuando se presiona "OK", muestra un mensaje de Toast indicando que los datos se guardaron
                        Toast.makeText(applicationContext, "Se cerró la aplicación", Toast.LENGTH_SHORT).show()
                    })
                    .setNegativeButton(android.R.string.cancel,  { dialog, which ->
                        // Cuando se presiona "Cancelar", muestra un mensaje de Toast indicando que no se guardaron los datos
                        Toast.makeText(applicationContext, "No se cerró la aplicacion", Toast.LENGTH_SHORT).show()
                    })
                    .show()  // Muestra el diálogo de alerta
                true
            }


            R.id.app -> {
                val intent = Intent(this, Info::class.java)
                actividadActual = 2
                startActivity(intent)
                true
            }

            R.id.peliculas -> {
                val intent = Intent(this, MainActivity::class.java)
                actividadActual=0
                startActivity(intent)
                true
            }

            R.id.editarpeli -> {
                actividadActual=1
                val intent = Intent(this, EditarPelicula::class.java)
                startActivity(intent)
                true
            }

            R.id.buscar -> {
                val filtro = findViewById<EditText>(R.id.filtro)
                val search = filtro.text.toString()

                if(filtro.visibility == View.INVISIBLE){
                        filtro.visibility = View.VISIBLE
                    }
                else{
                    filtro.visibility = View.INVISIBLE
                }


                Toast.makeText(applicationContext, "Búsqueda realizada: $search", Toast.LENGTH_SHORT).show()

                true
            }

            else -> super.onOptionsItemSelected(item)
        }

    }


}