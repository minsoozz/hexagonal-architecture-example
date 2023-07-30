package com.github.minsoozz.todo.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BoardTest {

    @Test
    fun `도메인을 생성한다`() {
        val board = Board("title", "content")
        assertEquals("title", board.title)
        assertEquals("content", board.content)
        assertEquals(null, board.id)
    }

    @Test
    fun `제목이 비어있으면 예외를 발생시킨다`() {
        val exception = assertThrows<IllegalArgumentException> {
            Board("", "")
        }
        assertEquals("제목은 공백이 아니어야 합니다", exception.message)
    }

    @Test
    fun `내용이 비어있으면 예외를 발생시킨다`() {
        val exception = assertThrows<IllegalArgumentException> {
            Board("title", "")
        }
        assertEquals("내용은 공백이 아니어야 합니다", exception.message)
    }
}