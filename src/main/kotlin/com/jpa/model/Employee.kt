package com.jpa.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
 data class Employee(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Int,
    val firstName : String,
    val lastName : String,
    val price : Double
 ) {

}