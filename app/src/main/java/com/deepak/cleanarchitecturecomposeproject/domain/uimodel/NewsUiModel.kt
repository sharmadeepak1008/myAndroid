package com.deepak.cleanarchitecturecomposeproject.domain.uimodel

import com.deepak.cleanarchitecturecomposeproject.data.response.Source


data class NewsUiModel(val author: String,
                       val content: String,
                       val description: String,
                       val publishedAt: String,
                       val source: Source,
                       val title: String,
                       val url: String,
                       val urlToImage: String
)
