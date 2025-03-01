package com.app.asurascans.helper

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle

inline fun <reified T : Activity> Context.startNewActivity(
    extras: Bundle? = null,
    flags: Int? = null
) {
    val intent = Intent(this, T::class.java)
    extras?.let { intent.putExtras(it) }
    flags?.let { intent.flags = it }
    startActivity(intent)
}
