package com.deepak.cleanarchitecturecomposeproject.data.mapper

import com.deepak.cleanarchitecturecomposeproject.data.response.Article
import com.deepak.cleanarchitecturecomposeproject.domain.uimodel.NewsUiModel

fun Article.toNewsUiModel() = NewsUiModel(
    author = author,
    content = content,
    description = description,
    publishedAt = publishedAt ,
    source = source,
    title = title,
    url = url,
    urlToImage = urlToImage

)
