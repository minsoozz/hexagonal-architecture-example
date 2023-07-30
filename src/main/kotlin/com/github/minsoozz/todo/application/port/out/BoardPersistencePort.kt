package com.github.minsoozz.todo.application.port.out

import com.github.minsoozz.todo.application.port.`in`.BoardUpdateCommand
import com.github.minsoozz.todo.domain.Board

interface BoardPersistencePort {
    fun read(id: Long): Board
    fun write(board: Board)
    fun update(id: Long, boardUpdateCommand: BoardUpdateCommand)
    fun delete(id: Long)
}