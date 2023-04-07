package iut.uca.projet.network

import retrofit2.http.GET

interface ApiWordService{
    @GET("v1/randomword")
    fun getWord(): String
}

