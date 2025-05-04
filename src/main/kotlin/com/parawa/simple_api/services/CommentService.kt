package com.parawa.simple_api.services

import com.parawa.simple_api.dtos.CommentCreationDto
import com.parawa.simple_api.entities.Comment
import com.parawa.simple_api.exceptions.CommentNotFoundException
import com.parawa.simple_api.mappers.CommentMapper
import com.parawa.simple_api.repositories.CommentRepository
import java.util.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CommentService(
    @Autowired val commentRepository: CommentRepository,
    @Autowired val postService: PostService,
    @Autowired val commentMapper: CommentMapper,
) {
    fun createComment(commentCreationDto: CommentCreationDto): Comment =
        postService.getPost(commentCreationDto.postId).let { post ->
            commentMapper
                .toEntity(commentCreationDto, post)
                .let(commentRepository::save)
        }

    fun getComments(postId: UUID): List<Comment> =
        postService.getPost(postId).let { post ->
            commentRepository.findAllByPostId(post.id!!)
        }

    fun getComment(postId: UUID, commentId: UUID): Comment =
        postService.getPost(postId).let { post ->
            commentRepository
                .findByIdAndPostId(commentId, post.id!!)
                .orElseThrow { CommentNotFoundException(commentId, post.id!!) }
        }
}
