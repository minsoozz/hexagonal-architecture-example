package com.github.minsoozz.todo.application.service

import com.github.minsoozz.todo.application.port.`in`.BoardReadCommand
import com.github.minsoozz.todo.application.port.`in`.BoardReadUseCase
import com.github.minsoozz.todo.application.port.`in`.BoardWriteUseCase
import com.github.minsoozz.todo.application.port.out.BoardPersistencePort
import com.github.minsoozz.todo.application.port.out.BoardReadResponse
import org.springframework.stereotype.Service

@Service
class BoardService(
    private val boardPersistencePort: BoardPersistencePort
) : BoardReadUseCase, BoardWriteUseCase {

    override fun read(boardReadCommand: BoardReadCommand): BoardReadResponse {
        val board = boardPersistencePort.read(boardReadCommand.id)
        return BoardReadResponse(board.title, board.content, board.id)
    }

    override fun write() {
    }
}