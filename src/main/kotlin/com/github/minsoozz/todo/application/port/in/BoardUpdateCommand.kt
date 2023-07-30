package com.github.minsoozz.todo.application.port.`in`

data class BoardUpdateCommand(
    val id: Long,
    val title: String,
    val content: String
)