package com.github.minsoozz.todo.application.port.`in`

interface BoardWriteUseCase {

    fun write(boardWriteCommand: BoardWriteCommand)
}