package com.app.asurascans.ui.screen.read

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
class ReadVM @Inject constructor(@ApplicationContext val context: Context) : BaseViewModel() {

    var chapterState by stateDataDelegate<UIState>(UIState.OnIdle)
        private set

    private var chapterId = ""

    fun getChapter(chapterId: String?) = viewModelScope .launch {
        this@ReadVM.chapterId = chapterId ?: ""
        chapterState = UIState.OnLoading.asNewState()
            try {
                val result = apiService.getChapter(chapterId ?: "")
                chapterState =   result.asNewResponseApiState()
            } catch (e: Exception) {
                chapterState =   UIState.OnError(e.message).asNewState()
            }
        }

    fun refresh() {
        getChapter(chapterId)
    }


}