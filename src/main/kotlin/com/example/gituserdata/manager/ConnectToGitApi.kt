package com.example.gituserdata.manager

import com.example.gituserdata.manager.error.handler.ConnectToGitRestTemplateErrorHandler
import com.example.gituserdata.model.GitUser
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class ConnectToGitApi (restTemplateBuilder: RestTemplateBuilder){

    val GIT_API_URL: String = "https://api.github.com/users/{login}"
    private val restTemplate: RestTemplate = restTemplateBuilder.errorHandler(ConnectToGitRestTemplateErrorHandler()).build()

    fun getGitUserData(login:String): GitUser {
        val map:HashMap<String,String> = HashMap()
        val httpHeaders = HttpHeaders()
        val entity: HttpEntity<String> = HttpEntity("body", httpHeaders)

        map["login"] = login
        val gitUser: GitUser =  restTemplate.exchange(GIT_API_URL, HttpMethod.GET, entity, GitUser::class.java, map).body?:throw NullPointerException()
        gitUser.setCalculations(gitUser.followers, gitUser.publicRepos)
        return  gitUser
    }
}
