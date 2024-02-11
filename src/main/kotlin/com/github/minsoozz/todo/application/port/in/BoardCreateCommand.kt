package com.github.minsoozz.todo.application.port.`in`

data class BoardCreateCommand(
    val title: String,
    val content: String
)