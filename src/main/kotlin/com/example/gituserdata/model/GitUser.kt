package com.example.gituserdata.model

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate

class GitUser{
    val id: Int? = null

    val login: String? = null

    val name: String? = null

    val type: String? = null

    @JsonAlias("avatar_url")
    val avatarUrl: String? = null

    @JsonAlias("created_at")
    val createdAt: LocalDate? = null

    var calculations: Float? = null

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    val followers: Int = 0

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonAlias("public_repos")
    val publicRepos: Int = 0

    fun setCalculations(follow:Int, publicRepo:Int) {
        this.calculations = if(follow != 0){
            6 / follow.toFloat() * (2+publicRepo)
        }else{
            0F
        }
    }

}
