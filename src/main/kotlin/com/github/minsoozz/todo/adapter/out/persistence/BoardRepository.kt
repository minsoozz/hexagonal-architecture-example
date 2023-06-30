package com.github.minsoozz.todo.adapter.out.persistence

import com.github.minsoozz.todo.application.port.out.BoardPersistencePort

class BoardRepository(
    private val boardJpaRepository: BoardJpaRepository
) : BoardPersistencePort