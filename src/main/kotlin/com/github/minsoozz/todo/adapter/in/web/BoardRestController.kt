package com.github.minsoozz.todo.adapter.`in`.web

import com.github.minsoozz.todo.application.port.`in`.BoardWriteUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/boards")
class TodoController(
    private val boardWriteUseCase: BoardWriteUseCase
)

@GetMapping
fun getTodo() {
}
