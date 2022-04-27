package com.example.gituserdata.manager.error.handler

import com.example.gituserdata.manager.error.exception.GitApiStatusException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.client.ClientHttpResponse
import org.springframework.web.client.ResponseErrorHandler
import org.springframework.http.HttpStatus.Series.CLIENT_ERROR

import org.springframework.http.HttpStatus.Series.SERVER_ERROR


class ConnectToGitRestTemplateErrorHandler : ResponseErrorHandler{

    override fun hasError(response: ClientHttpResponse): Boolean {
        return (response.statusCode.series() == CLIENT_ERROR ||
                response.statusCode.series() == SERVER_ERROR)
    }

    override fun handleError(response: ClientHttpResponse) {
        if(response.statusCode.series() == CLIENT_ERROR){
            throw GitApiStatusException(response.statusCode,response.statusText)

        }else if(response.statusCode.series() == SERVER_ERROR){
            throw GitApiStatusException(response.statusCode,"Błąd po stronie serwera")
        }
    }
}
