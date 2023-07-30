package com.github.minsoozz.todo.application.service

import com.github.minsoozz.todo.application.port.`in`.*
import com.github.minsoozz.todo.application.port.out.BoardPersistencePort
import com.github.minsoozz.todo.application.port.out.BoardReadResponse
import com.github.minsoozz.todo.domain.Board
import org.springframework.stereotype.Service

@Service
class BoardService(
    private val boardPersistencePort: BoardPersistencePort
) : BoardReadUseCase, BoardWriteUseCase, BoardUpdateUseCase, BoardDeleteUseCase {

    override fun read(boardReadCommand: BoardReadCommand): BoardReadResponse {
        val board = boardPersistencePort.read(boardReadCommand.id)
        return BoardReadResponse(board.title, board.content, board.id ?: 0L)
    }

    override fun write(boardWriteCommand: BoardWriteCommand) {
        val board = Board(boardWriteCommand.title, boardWriteCommand.content)
        boardPersistencePort.write(board)
    }

    override fun update(id: Long, boardUpdateCommand: BoardUpdateCommand) {
        boardPersistencePort.update(id, boardUpdateCommand)
    }

    override fun delete(id: Long) {
        boardPersistencePort.delete(id)
    }
}