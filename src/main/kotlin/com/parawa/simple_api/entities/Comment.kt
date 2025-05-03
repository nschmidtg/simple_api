package com.parawa.simple_api.entities

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "comments")
class Comment {
    @Id @GeneratedValue(strategy = GenerationType.UUID) var id: UUID? = null
    @ManyToOne @JoinColumn(name = "post_id") var post: Post? = null
    var body: String? = null
}
