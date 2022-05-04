package com.example.myfirstapplication.data.network

import com.example.myfirstapplication.core.RetrofitHelper
import com.example.myfirstapplication.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class QuoteService @Inject constructor(private val api:QuoteApiClient) {


    suspend fun getQuotes():List<QuoteModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}
//val response:response<List<QuoteModel>> = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
//En el video esta como asi