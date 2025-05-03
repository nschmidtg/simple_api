package com.parawa.simple_api.repositories

import com.parawa.simple_api.entities.Post
import java.util.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository interface PostRepository : JpaRepository<Post, UUID>
