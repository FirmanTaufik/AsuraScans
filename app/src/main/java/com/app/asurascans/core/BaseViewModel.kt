package com.app.asurascans.core

import androidx.lifecycle.ViewModel
import com.app.asurascans.services.ApiService
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {
    val TAG ="FirmanTAG"
    @Inject
    protected lateinit var apiService: ApiService

}