package com.example.macropayapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MenuActivity : AppCompatActivity() {
    val urlBase = "https://pokeapi.co/api/v2/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val retrofit = Retrofit.Builder()
            .baseUrl(urlBase)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(PokemonApiService::class.java)

        lifecycleScope.launch {
            try {
                val response = service.getPokemonList()
                val pokemonList = response.results.toMutableList() // Convertir la lista a mutable
                pokemonList.sortBy { it.name } // Ordenar la lista por nombre

                val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
                recyclerView.layoutManager = LinearLayoutManager(this@MenuActivity)
                recyclerView.adapter = PokemonAdapter(pokemonList)
            } catch (e: Exception) {
                // Manejar cualquier excepción que pueda ocurrir
            }
        }
    }
}
