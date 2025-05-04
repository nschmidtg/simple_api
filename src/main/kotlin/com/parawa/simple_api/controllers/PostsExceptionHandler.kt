package com.parawa.simple_api.controllers

import com.parawa.simple_api.controllers.vms.ErrorVM
import com.parawa.simple_api.exceptions.CommentNotFoundException
import com.parawa.simple_api.exceptions.PostNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class PostsExceptionHandler {

    @ExceptionHandler(
        PostNotFoundException::class,
        CommentNotFoundException::class
    )
    fun handlePostNotFoundException(
        exception: Exception
    ): ResponseEntity<ErrorVM> {
        val apiError =
            ErrorVM(HttpStatus.NOT_FOUND.toString(), exception.message)
        val response: ResponseEntity<ErrorVM> =
            ResponseEntity<ErrorVM>(apiError, HttpStatus.NOT_FOUND)
        return response
    }
}
