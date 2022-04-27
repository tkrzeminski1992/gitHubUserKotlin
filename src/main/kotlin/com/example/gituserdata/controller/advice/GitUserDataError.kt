package com.example.gituserdata.controller.advice

import com.example.gituserdata.manager.error.exception.GitApiStatusException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody

@ControllerAdvice
class GitUserDataError {

    @ResponseBody
    @ExceptionHandler(GitApiStatusException::class)
    fun gitUserDataError(exception: GitApiStatusException): ResponseEntity<String>{
        return ResponseEntity<String> (exception.message, exception.status)
    }
}
