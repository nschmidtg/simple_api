package com.parawa.simple_api.entities

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "posts")
data class Post(
    @Id @GeneratedValue(strategy = GenerationType.UUID) var id: UUID? = null,
    var title: String,
)
