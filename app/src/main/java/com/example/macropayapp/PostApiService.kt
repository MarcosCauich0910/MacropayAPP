package com.example.macropayapp

import retrofit2.Retrofit
import retrofit2.http.GET

interface PokemonApiService {
    @GET("pokemon")
    suspend fun getPokemonList(): PokemonListResponse
}


