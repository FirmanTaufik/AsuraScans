package com.app.asurascans.ui.screen.detail

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringArrayResource
import androidx.lifecycle.viewModelScope
import com.app.asurascans.R
import com.app.asurascans.core.BaseViewModel
import com.app.asurascans.core.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailVM @Inject constructor(@ApplicationContext val context: Context) : BaseViewModel() {

    var detailState by stateDataDelegate<UIState>(UIState.OnIdle)
        private set

    fun getDetail(seriesId: String?) = viewModelScope .launch {
        detailState = UIState.OnLoading.asNewState()
            try {
                val result = apiService.getDetail(seriesId ?: "")
                detailState =   result.asNewResponseApiState()
            } catch (e: Exception) {
                detailState =   UIState.OnError(e.message).asNewState()
            }
        }




}