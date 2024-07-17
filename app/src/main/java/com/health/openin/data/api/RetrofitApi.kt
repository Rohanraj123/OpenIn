package com.health.openin.data.api

import com.health.openin.data.models.Response
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitApi {
    @GET("dashboardNew")
    fun getData(): Call<Response>
}