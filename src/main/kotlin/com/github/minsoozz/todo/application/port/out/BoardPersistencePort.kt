package com.github.minsoozz.todo.application.port.out

import com.github.minsoozz.todo.domain.Board

interface BoardPersistencePort {
    fun read(id: Long): Board
}