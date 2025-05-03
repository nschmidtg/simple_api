package com.parawa.simple_api.repositories

import com.parawa.simple_api.entities.Comment
import java.util.*
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository : JpaRepository<Comment, UUID> {
    fun findAllByPostId(postId: UUID): List<Comment>
    fun findByIdAndPostId(id: UUID, postId: UUID): Optional<Comment>
}
