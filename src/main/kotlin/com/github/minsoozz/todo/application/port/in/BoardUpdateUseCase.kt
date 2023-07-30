package com.github.minsoozz.todo.application.port.`in`

interface BoardUpdateUseCase {

    fun update(id: Long, boardUpdateCommand: BoardUpdateCommand)
}