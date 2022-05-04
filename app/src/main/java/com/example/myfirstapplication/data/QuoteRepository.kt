package com.example.myfirstapplication.data

import com.example.myfirstapplication.data.database.dao.QuoteDao
import com.example.myfirstapplication.data.database.entities.QuoteEntity
import com.example.myfirstapplication.data.model.QuoteModel
import com.example.myfirstapplication.data.network.QuoteService
import com.example.myfirstapplication.domain.model.Quote
import com.example.myfirstapplication.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private  val api : QuoteService,
    private  val quoteDao: QuoteDao
) {



    suspend fun getAllQuotesFromApi():List<Quote> {
        val response: List<QuoteModel> = api.getQuotes()
        return response.map { it.toDomain() }
    }
    suspend fun getAllQuotesFromDatabase():List<Quote>{
        val response: List<QuoteEntity> = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes:List<QuoteEntity>){
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }
}