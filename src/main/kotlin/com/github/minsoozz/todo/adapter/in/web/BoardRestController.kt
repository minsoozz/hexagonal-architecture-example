package com.github.minsoozz.todo.adapter.`in`.web

import com.github.minsoozz.todo.application.port.`in`.*
import com.github.minsoozz.todo.application.port.out.BoardReadResponse
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/boards")
class TodoController(
    private val boardReadUseCase: BoardReadUseCase,
    private val boardWriteUseCase: BoardWriteUseCase,
    private val boardUpdateUseCase: BoardUpdateUseCase,
    private val boardDeleteUseCase: BoardDeleteUseCase
) {

    @GetMapping("/{id}")
    fun read(@PathVariable id: Long): BoardReadResponse {
        return boardReadUseCase.read(BoardReadCommand(id))
    }

    @PostMapping
    fun write(@RequestBody boardWriteCommand: BoardWriteCommand) {
        return boardWriteUseCase.write(boardWriteCommand)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody boardUpdateCommand: BoardUpdateCommand) {
        return boardUpdateUseCase.update(id, boardUpdateCommand)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        return boardDeleteUseCase.delete(id)
    }
}

