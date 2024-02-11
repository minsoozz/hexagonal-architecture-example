package com.github.minsoozz.todo.application.service

import com.github.minsoozz.todo.application.port.`in`.BoardCreateCommand
import com.github.minsoozz.todo.application.port.`in`.BoardReadCommand
import com.github.minsoozz.todo.application.port.`in`.BoardUpdateCommand
import com.github.minsoozz.todo.application.port.`in`.BoardUseCase
import com.github.minsoozz.todo.application.port.out.BoardPersistencePort
import com.github.minsoozz.todo.application.port.out.BoardReadResponse
import com.github.minsoozz.todo.domain.Board
import org.springframework.stereotype.Service

@Service
class BoardService(
    private val boardPersistencePort: BoardPersistencePort
) : BoardUseCase {

    override fun create(boardCreateCommand: BoardCreateCommand) {
        val board = Board(boardCreateCommand.title, boardCreateCommand.content)
        boardPersistencePort.create(board)
    }

    override fun read(boardReadCommand: BoardReadCommand): BoardReadResponse {
        val board = boardPersistencePort.read(boardReadCommand.id)
        return BoardReadResponse(board.title, board.content, board.id ?: 0L)
    }

    override fun update(id: Long, boardUpdateCommand: BoardUpdateCommand) {
        boardPersistencePort.update(id, boardUpdateCommand)
    }

    override fun delete(id: Long) {
        boardPersistencePort.delete(id)
    }
}