package com.app.asurascans.core

import com.google.gson.annotations.SerializedName

interface BaseModelResponse {

    var retcode: Long
    var message: String
    var meta    : Meta?

    data class Meta (

        @SerializedName("request_id"   ) var requestId   : String? = null,
        @SerializedName("timestamp"    ) var timestamp   : Long?    = null,
        @SerializedName("process_time" ) var processTime : String? = null

    )

}