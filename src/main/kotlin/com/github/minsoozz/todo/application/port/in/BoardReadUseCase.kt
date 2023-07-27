package com.github.minsoozz.todo.application.port.`in`

import com.github.minsoozz.todo.application.port.out.BoardReadResponse

interface BoardReadUseCase {
    fun read(boardReadCommand: BoardReadCommand): BoardReadResponse
}