package com.parawa.simple_api.services

import com.parawa.simple_api.entities.Post
import com.parawa.simple_api.repositories.PostRepository
import java.util.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PostService(
    @Autowired private val postRepository: PostRepository,
) {
    fun save(post: Post) = postRepository.save(post)

    fun getAllPosts() = postRepository.findAll()

    fun getPost(id: UUID) =
        postRepository.findById(id).orElseThrow { Exception("Post not found") }
}
