package com.example.myfirstapplication.domain

import com.example.myfirstapplication.data.QuoteRepository
import com.example.myfirstapplication.data.model.QuoteModel
import com.example.myfirstapplication.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository) {

    suspend operator fun invoke():Quote?{
        val quotes = repository.getAllQuotesFromDatabase()
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}