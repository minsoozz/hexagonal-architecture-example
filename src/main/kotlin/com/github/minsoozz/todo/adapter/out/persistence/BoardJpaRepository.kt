package com.github.minsoozz.todo.adapter.out.persistence

import org.springframework.data.jpa.repository.JpaRepository

interface BoardJpaRepository : JpaRepository<BoardJpaEntity, Long>