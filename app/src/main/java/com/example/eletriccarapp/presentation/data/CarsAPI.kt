package com.example.eletriccarapp.presentation.data

import retrofit2.Call
import retrofit2.http.GET

interface CarsAPI {

    @GET("cars.json")
    fun getAllCars() : Call<List<Carro>>

}