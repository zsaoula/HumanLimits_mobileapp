package iut.uca.projet.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory


const val BASU_URL: String = "https://api.api-ninjas.com"

var retrofit = Retrofit.Builder()
    .baseUrl(BASU_URL)
    .addConverterFactory(ScalarsConverterFactory.create())
    .build()

object WordApi{
    val retrofitService : ApiWordService by lazy{
        retrofit.create(ApiWordService::class.java)
    }
}