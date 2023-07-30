package com.github.minsoozz.todo.domain

class Board(
    val title: String,
    val content: String,
    val id: Long? = null
) {
    init {
        require(title.isNotBlank()) {
            throw IllegalArgumentException("제목은 공백이 아니어야 합니다")
        }
        require(content.isNotBlank()) {
            throw IllegalArgumentException("내용은 공백이 아니어야 합니다")
        }
    }
}