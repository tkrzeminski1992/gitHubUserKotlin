package com.example.gituserdata.manager.error.exception

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class GitApiStatusException(httpStatus: HttpStatus, message: String) : ResponseStatusException(httpStatus, message) {

}
