package com.example.gituserdata.dao

import com.example.gituserdata.dao.entity.UserRequest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RequestUserRepo : JpaRepository<UserRequest, String> {
}
