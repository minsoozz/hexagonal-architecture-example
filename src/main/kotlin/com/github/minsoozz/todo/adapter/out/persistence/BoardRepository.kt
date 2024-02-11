package com.github.minsoozz.todo.adapter.out.persistence

import com.github.minsoozz.todo.application.port.`in`.BoardUpdateCommand
import com.github.minsoozz.todo.application.port.out.BoardPersistencePort
import com.github.minsoozz.todo.domain.Board
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional
class BoardRepository(
    private val boardJpaRepository: BoardJpaRepository
) : BoardPersistencePort {
    override fun read(id: Long): Board {
        return BoardMapper.entityToDomain(boardJpaRepository.findById(id).orElseThrow {
            RuntimeException("해당 게시글이 존재하지 않습니다. id: $id")
        })
    }

    override fun create(board: Board) {
        boardJpaRepository.save(BoardMapper.domainToEntity(board))
    }

    override fun update(id: Long, boardUpdateCommand: BoardUpdateCommand) {
        val board = boardJpaRepository.findById(id).orElseThrow {
            RuntimeException("해당 게시글이 존재하지 않습니다. id: $id")
        }
        board.update(boardUpdateCommand.title, boardUpdateCommand.content)
    }

    override fun delete(id: Long) {
        boardJpaRepository.deleteById(id)
    }
}