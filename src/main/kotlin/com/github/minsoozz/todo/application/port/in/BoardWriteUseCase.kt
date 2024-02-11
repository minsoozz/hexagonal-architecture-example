package com.github.minsoozz.todo.application.port.`in`

interface BoardWriteUseCase {

    fun write(boardCreateCommand: BoardCreateCommand)
}