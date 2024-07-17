package com.health.openin.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.health.openin.data.repo.GetDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.health.openin.data.models.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

@HiltViewModel
class DashboardScreenViewModel @Inject constructor(
    private val getDataRepository: GetDataRepository
): ViewModel() {

    private val _apiData = MutableStateFlow<Response?>(null)
    val apiData: StateFlow<Response?>
        get() = _apiData

    fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = getDataRepository.getData()
                Log.d("ViewModel", "Result fetched Successfully from the api : ${result.isSuccess}")
                if (result.isSuccess) {
                    val apiData = result.getOrNull()
                    _apiData.value = apiData
                } else {
                    _apiData.value = null
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _apiData.value = null
            }
        }
    }
}