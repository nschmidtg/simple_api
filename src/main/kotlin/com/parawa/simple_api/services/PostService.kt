package com.parawa.simple_api.services

import com.parawa.simple_api.dtos.PostCreationDto
import com.parawa.simple_api.entities.Post
import com.parawa.simple_api.exceptions.PostNotFoundException
import com.parawa.simple_api.mappers.PostMapper
import com.parawa.simple_api.repositories.PostRepository
import java.util.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PostService(
    @Autowired private val postRepository: PostRepository,
    @Autowired private val postMapper: PostMapper,
) {
    fun save(post: PostCreationDto): Post =
        post.let(postMapper::toEntity).let(postRepository::save)

    fun getAllPosts(): List<Post> = postRepository.findAll()

    fun getPost(id: UUID): Post =
        postRepository.findById(id).orElseThrow { PostNotFoundException(id) }
}
