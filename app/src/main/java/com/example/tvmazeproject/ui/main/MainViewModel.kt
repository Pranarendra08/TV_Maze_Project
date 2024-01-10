package com.example.tvmazeproject.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.tvmazeproject.api.ApiConfig
import com.example.tvmazeproject.api.response.ResponseCastItem
import com.example.tvmazeproject.api.response.ResponseShow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(application: Application) : AndroidViewModel(application) {

    companion object{
        private const val TAG = "MainViewModel"
    }

    private val _detailShow = MutableLiveData<ResponseShow>()
    val detailShow: LiveData<ResponseShow> = _detailShow

    private val _listCast = MutableLiveData<List<ResponseCastItem>>()
    val listCast: LiveData<List<ResponseCastItem>> = _listCast

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getDetailShow(data: Int) {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getShowDetail(data)
        client.enqueue(object : Callback<ResponseShow> {
            override fun onResponse(
                call: Call<ResponseShow>,
                response: Response<ResponseShow>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        _detailShow.value = response.body()
                    }
                    else {
                        val errorBody = response.errorBody()?.string()
                        Log.e(TAG, "$errorBody")
                    }
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ResponseShow>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }

    fun getListCast(data: Int) {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getCastList(data)
        client.enqueue(object : Callback<List<ResponseCastItem>> {
            override fun onResponse(
                call: Call<List<ResponseCastItem>>,
                response: Response<List<ResponseCastItem>>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        _listCast.value = response.body()
                    } else {
                        val errorBody = response.errorBody()?.string()
                        Log.e(TAG, "$errorBody")
                    }
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<ResponseCastItem>>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })
    }
}