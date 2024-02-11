package com.github.minsoozz.todo.adapter.`in`.web

import com.github.minsoozz.todo.application.port.`in`.BoardCreateCommand
import com.github.minsoozz.todo.application.port.`in`.BoardReadCommand
import com.github.minsoozz.todo.application.port.`in`.BoardUpdateCommand
import com.github.minsoozz.todo.application.port.`in`.BoardUseCase
import com.github.minsoozz.todo.application.port.out.BoardReadResponse
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/boards")
class TodoController(
    private val boardUseCase: BoardUseCase
) {

    @PostMapping
    fun write(@RequestBody boardCreateCommand: BoardCreateCommand) {
        return boardUseCase.create(boardCreateCommand)
    }

    @GetMapping("/{id}")
    fun read(@PathVariable id: Long): BoardReadResponse {
        return boardUseCase.read(BoardReadCommand(id))
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody boardUpdateCommand: BoardUpdateCommand) {
        return boardUseCase.update(id, boardUpdateCommand)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        return boardUseCase.delete(id)
    }
}

