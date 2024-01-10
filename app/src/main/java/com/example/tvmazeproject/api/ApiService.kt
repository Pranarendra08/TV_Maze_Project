package com.example.tvmazeproject.api

import com.example.tvmazeproject.api.response.ResponseCastItem
import com.example.tvmazeproject.api.response.ResponseShow
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("shows/{id}")
    fun getShowDetail(
        @Path("id") id: Int
    ): Call<ResponseShow>

    @GET("shows/{id}/cast")
    fun getCastList(
        @Path("id") id: Int
    ): Call<List<ResponseCastItem>>
}