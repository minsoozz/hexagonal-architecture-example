package com.github.minsoozz.todo.application.port.`in`

data class BoardWriteCommand(
    val title: String,
    val content: String
)