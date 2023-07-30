package com.github.minsoozz.todo.adapter.out.persistence

import com.github.minsoozz.todo.domain.Board

class BoardMapper {

    companion object {
        fun entityToDomain(boardJpaEntity: BoardJpaEntity): Board {
            return Board(boardJpaEntity.title, boardJpaEntity.content, boardJpaEntity.id)
        }

        fun domainToEntity(board: Board): BoardJpaEntity {
            return BoardJpaEntity(board.title, board.content)
        }
    }
}