package com.example.myfirstapplication.domain

import com.example.myfirstapplication.data.model.QuoteModel
import com.example.myfirstapplication.data.QuoteRepository
import com.example.myfirstapplication.data.database.entities.toDatabase
import com.example.myfirstapplication.domain.model.Quote
import javax.inject.Inject
import kotlin.text.Typography.quote

class GetQuotesUseCase @Inject constructor(private val repository : QuoteRepository) {

    suspend operator fun invoke():List<Quote>{
        val quotes = repository.getAllQuotesFromApi()

        return if(quotes.isNotEmpty()){
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        }else{
            repository.getAllQuotesFromDatabase()
        }
    }

}