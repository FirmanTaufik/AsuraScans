package com.app.asurascans.core

import androidx.lifecycle.ViewModel
import com.app.asurascans.services.ApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

abstract class BaseViewModel : ViewModel() {
    val TAG ="FirmanTAG"
    @Inject
    protected lateinit var apiService: ApiService

    fun UIState.asNewState() = MutableStateFlow(this)

    fun <T> stateDataDelegate(defaultValue: T): ReadWriteProperty<Any, StateFlow<T>> =
        object : ReadWriteProperty<Any, StateFlow<T>> {
            private val data: MutableStateFlow<T> = MutableStateFlow(defaultValue)

            override fun getValue(thisRef: Any, property: KProperty<*>): StateFlow<T> = data

            override fun setValue(thisRef: Any, property: KProperty<*>, value: StateFlow<T>) {
                data.value = value.value
            }
        }

}