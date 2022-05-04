package com.example.myfirstapplication.domain.model

import com.example.myfirstapplication.data.database.entities.QuoteEntity
import com.example.myfirstapplication.data.model.QuoteModel

data class Quote (val quote:String, val author:String)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)