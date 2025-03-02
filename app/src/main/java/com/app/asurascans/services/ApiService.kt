package com.app.asurascans.services

import com.app.asurascans.ui.screen.home.UpdateModelResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/v1/series/update")
    suspend fun getLatestUpdate(): Response<UpdateModelResponse>
}