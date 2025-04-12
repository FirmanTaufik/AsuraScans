package com.app.asurascans.helper

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

inline fun <reified T : Activity> Activity.startNewActivity(
    extras: Bundle? = null,
    flags: Int? = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT,
    requestCode :Int? = 100

) {
    val intent = Intent(this, T::class.java)
    extras?.let { intent.putExtras(it) }
    flags?.let { intent.flags = it }
    if (requestCode != null) {
        startActivityForResult(intent, requestCode)
    }
}

fun <T> T.fromObjectToJson(): String = try {
    Gson().toJson(this)
} catch (e: Exception) {
    ""
}

inline fun <reified T> String.fromJsonToObject(): T? {
    return try {
        val type = object : TypeToken<T>() {}.type
        Gson().fromJson<T>(this, type)
    } catch (e: Exception) {
        null
    }
}