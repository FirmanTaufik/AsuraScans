package com.app.asurascans.core

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.asurascans.di.SnackbarManager
import com.app.asurascans.services.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import java.util.TimerTask
import javax.inject.Inject
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

 abstract class BaseViewModel : ViewModel() {
    val TAG = "FirmanTAG"

    @Inject
    protected lateinit var apiService: ApiService


     var showFab = mutableStateOf(false)
         private set

     fun showFab(valueBoolean: Boolean){
         showFab.value= valueBoolean
     }


     var bottomSheetState = mutableStateOf(false)
        private set

    fun setBottomSheetSate(value: Boolean) {
        bottomSheetState.value = value
    }


    var snackbarMessage  by stateDataDelegate<UIState>(UIState.OnIdle)
        private set

    fun showSnackbar(message: String, isErrorAlert:Boolean) {
        viewModelScope.launch {
            snackbarMessage = if (isErrorAlert) UIState.OnError(message).asNewState()
            else UIState.OnSuccess(message).asNewState()
            delay(2000L)
            snackbarMessage= UIState.OnIdle.asNewState()
       }
    }

    fun <T> T.asNewState() = MutableStateFlow(this)

    fun  <T> Response<T>.asNewResponseApiState(): StateFlow<UIState> {
        return try {
                val dataResponse = this as Response<*>
                if (dataResponse.isSuccessful)
                    MutableStateFlow(UIState.OnSuccess(dataResponse.body())  )
                else{
                    showSnackbar("gagal memuat response api ${dataResponse.code()}", true)
                    MutableStateFlow(UIState.OnError() )
                }
        } catch (e: Exception) {
            showSnackbar(e.message ?: "terjadi kesalahan parsing data", true)
            MutableStateFlow(UIState.OnIdle )
        }
    }


   /* fun <T> T.asNewResponseApiState(): MutableStateFlow<T> {
        return try {
            if (this is UIState.OnSuccess<*>) {
                val dataResponse = this as Response<*>
                if (dataResponse.isSuccessful)
                    MutableStateFlow(UIState.OnSuccess(dataResponse.body()) as T)
                else{
                    showSnackbar("gagal memuat response api ${dataResponse.code()}")
                    MutableStateFlow(UIState.OnIdle  as T)
                }
            } else MutableStateFlow(UIState.OnIdle as T)
        } catch (e: Exception) {
            showSnackbar(e.message ?: "terjadi kesalahan parsing data")
            MutableStateFlow(UIState.OnIdle as T)
        }

    }*/



fun <T> stateDataDelegate(defaultValue: T): ReadWriteProperty<Any, StateFlow<T>> =
    object : ReadWriteProperty<Any, StateFlow<T>> {
        private var data: MutableStateFlow<T> = MutableStateFlow(defaultValue)


        override fun getValue(thisRef: Any, property: KProperty<*>) = data

        override fun setValue(thisRef: Any, property: KProperty<*>, value: StateFlow<T>) {
            data.value = value.value
        }
    }

}