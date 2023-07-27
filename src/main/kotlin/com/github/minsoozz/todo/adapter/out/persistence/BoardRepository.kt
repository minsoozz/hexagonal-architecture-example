package com.github.minsoozz.todo.adapter.out.persistence

import com.github.minsoozz.todo.application.port.out.BoardPersistencePort
import com.github.minsoozz.todo.domain.Board
import org.springframework.stereotype.Repository
import java.lang.RuntimeException

@Repository
class BoardRepository(
    private val boardJpaRepository: BoardJpaRepository
) : BoardPersistencePort {
    override fun read(id: Long): Board {
        return BoardMapper.entityToDomain(boardJpaRepository.findById(id).orElseThrow {
            RuntimeException("Board not found with id: $id")
        })
    }
}