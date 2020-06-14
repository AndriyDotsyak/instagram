package com.instagram.screen.home

import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import javax.inject.Inject

class HomeViewModel @Inject constructor() : ViewModel() {

    fun <T> jsonToObject(json: String, classOfT: Class<T>): T =
        Gson().fromJson(json, classOfT)
}