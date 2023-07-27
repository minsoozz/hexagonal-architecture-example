package com.github.minsoozz.todo.adapter.`in`.web

import com.github.minsoozz.todo.application.port.`in`.BoardReadCommand
import com.github.minsoozz.todo.application.port.`in`.BoardReadUseCase
import com.github.minsoozz.todo.application.port.`in`.BoardWriteUseCase
import com.github.minsoozz.todo.application.port.out.BoardReadResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/boards")
class TodoController(
    private val boardReadUseCase: BoardReadUseCase,
    private val boardWriteUseCase: BoardWriteUseCase
) {

    @GetMapping("/{id}")
    fun read(@PathVariable id: Long): BoardReadResponse {
        return boardReadUseCase.read(BoardReadCommand(id))
    }
}

