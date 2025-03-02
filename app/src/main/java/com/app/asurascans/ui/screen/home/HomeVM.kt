package com.app.asurascans.ui.screen.home

import androidx.lifecycle.viewModelScope
import com.app.asurascans.core.BaseViewModel
import com.app.asurascans.core.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor( ) : BaseViewModel() {
    var homeState by stateDataDelegate<UIState>(UIState.OnIdle)
        private set
    fun getHome() = viewModelScope
        .launch {
            homeState = UIState.OnLoading.asNewState()
            homeState = try {
                val result = apiService.getLatestUpdate()
                UIState.OnSuccess(result.body()).asNewState()
            } catch (e: Exception) {
                UIState.OnError(e.message).asNewState()
            }
        }

}