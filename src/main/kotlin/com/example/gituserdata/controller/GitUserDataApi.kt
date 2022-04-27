package com.example.gituserdata.controller

import com.example.gituserdata.manager.ConnectToGitApi
import com.example.gituserdata.manager.SaveUserRequest
import com.example.gituserdata.model.GitUser
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class GitUserDataApi constructor(@Autowired val saveUserRequest: SaveUserRequest, val connectToGitApi: ConnectToGitApi) {
    val log: Logger = LoggerFactory.getLogger(javaClass)


    @GetMapping("/user/{id}")
    fun getGitUserDataAndSaveUserRequest(@PathVariable("id") login:String):GitUser?{
        saveUserRequest.findAndSaveUserRequestData(login)
        return connectToGitApi.getGitUserData(login)
    }
}
