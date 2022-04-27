package com.example.gituserdata.manager

import com.example.gituserdata.dao.RequestUserRepo
import com.example.gituserdata.dao.entity.UserRequest
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class SaveUserRequest (@Autowired val requestUserRepo: RequestUserRepo){
    val log: Logger = LoggerFactory.getLogger(javaClass)


    fun findAndSaveUserRequestData(login: String){
        val userRequestOptional : Optional<UserRequest> = requestUserRepo.findById(login)
        val userRequest: UserRequest = if(userRequestOptional.isPresent){
            userRequestOptional.get()
        }else {
            UserRequest(login)
        }
        userRequest.increment()
        requestUserRepo.save(userRequest)
    }




}
