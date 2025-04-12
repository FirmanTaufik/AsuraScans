package com.app.asurascans.services

import com.app.asurascans.ui.screen.detail.CommentModelResponse
import com.app.asurascans.ui.screen.detail.DetailModelResponse
import com.app.asurascans.ui.screen.home.UpdateModelResponse
import com.app.asurascans.ui.screen.read.ReadModelResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("api/v1/series/update")
    suspend fun getLatestUpdate(): Response<UpdateModelResponse>

    @GET("api/v1/series/detail/{seriesId}")
    suspend fun getDetail(@Path("seriesId") seriesId: String): Response<DetailModelResponse>

    @GET("api/v1/comment/list/series/{seriesId}?sort_by=comment_like")
    suspend fun getComment(@Path("seriesId") seriesId: String): Response<CommentModelResponse>

    @GET("api/v1/chapter/detail/{chapterId}")
    suspend fun getChapter(@Path("chapterId") seriesId: String): Response<ReadModelResponse>


}