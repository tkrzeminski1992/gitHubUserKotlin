package com.example.gituserdata.dao.entity
import javax.persistence.*

@Entity
@Table(name = "USER_REQUEST")
class UserRequest {
    @Id
    @Column(name="LOGIN")
    var login: String = ""

    @Column(nullable = false, name = "REQUEST_COUNT")
    var requestCount: Int = 0

    constructor(login: String) {
        this.login = login
    }

    constructor()

    fun increment() {
        this.requestCount++
    }
}
