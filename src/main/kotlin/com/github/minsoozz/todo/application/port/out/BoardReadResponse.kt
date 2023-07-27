package com.github.minsoozz.todo.application.port.out

data class BoardReadResponse(
    val title: String,
    val content: String,
    val id: Long
)