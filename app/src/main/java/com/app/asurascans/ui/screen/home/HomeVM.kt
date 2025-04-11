package com.app.asurascans.ui.screen.home

import android.content.Context
import android.util.Log
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
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel

class HomeVM @Inject constructor(@ApplicationContext val context: Context) : BaseViewModel() {
    var homeState by stateDataDelegate<UIState>(UIState.OnIdle)
        private set

    fun getHome() = viewModelScope.launch {
            homeState = UIState.OnLoading.asNewState()
        try {
            val result = apiService.getLatestUpdate()
            homeState = result.asNewResponseApiState()
            updateList(result.body()?.data?.all ?: arrayListOf())
        } catch (e: Exception) {
            showSnackbar(e.message ?: "",true)
            homeState = UIState.OnError(e.message).asNewState()
        }
    }

    var itemsSelected by stateDataDelegate(listOf<UpdateModelResponse.List>())
        private set

    fun updateList(newList: List<UpdateModelResponse.List>) {
        itemsSelected = newList.asNewState()
    }

    val listBottom = context.resources.getStringArray(R.array.list_type_home_bottom)

    var itemTypeBottomSelectedIndex by stateDataDelegate(0)
        private set

    fun setItemTypeBottomSelectedIndex(int: Int) {
        if (homeState.value is UIState.OnSuccess<*>) {
            val data = (homeState.value as UIState.OnSuccess<*>).data as UpdateModelResponse
            itemTypeBottomSelectedIndex = int.asNewState()
            when (itemTypeBottomSelectedIndex.value) {
                0 -> updateList(data.data?.all?.toList() ?: arrayListOf())
                1 -> updateList(data.data?.manga?.toList() ?: arrayListOf())
                2 -> updateList(data.data?.manhwa?.toList() ?: arrayListOf())
                else -> updateList(data.data?.manhua?.toList() ?: arrayListOf())
            }
        }
    }
}

