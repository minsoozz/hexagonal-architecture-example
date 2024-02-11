package com.github.minsoozz.todo.application.port.`in`

import com.github.minsoozz.todo.application.port.out.BoardReadResponse

interface BoardUseCase {

    fun create(boardCreateCommand: BoardCreateCommand)
    fun read(boardReadCommand: BoardReadCommand): BoardReadResponse

    fun update(id: Long, boardUpdateCommand: BoardUpdateCommand)
    fun delete(id: Long)
}