package com.parawa.simple_api.controllers

import com.parawa.simple_api.mappers.CommentMapper
import com.parawa.simple_api.mappers.PostMapper
import com.parawa.simple_api.services.CommentService
import com.parawa.simple_api.services.PostService
import java.util.*
import openapi.generated.api.PostsApi
import openapi.generated.model.CommentVM
import openapi.generated.model.CreateCommentRequest
import openapi.generated.model.CreatePostRequest
import openapi.generated.model.PostVM
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.stereotype.Controller

@Controller
class PostsController(
    @Autowired private val postService: PostService,
    @Autowired private val commentService: CommentService,
    @Autowired private val postMapper: PostMapper,
    @Autowired private val commentMapper: CommentMapper,
) : PostsApi {
    override fun createPost(
        createPostRequest: CreatePostRequest
    ): ResponseEntity<PostVM> =
        createPostRequest
            .let(postMapper::toEntity)
            .let(postService::save)
            .let(postMapper::toVM)
            .let(::ok)

    override fun getPosts(): ResponseEntity<List<PostVM>> =
        postService.getAllPosts().map(postMapper::toVM).let { ok(it) }

    override fun getPost(id: UUID): ResponseEntity<PostVM> =
        id.let(postService::getPost).let(postMapper::toVM).let { ok(it) }

    override fun createComment(
        postId: UUID,
        createCommentRequest: CreateCommentRequest
    ): ResponseEntity<CommentVM> =
        commentMapper
            .toCommentCreationDto(postId, createCommentRequest)
            .let(commentService::createComment)
            .let { commentMapper.toVM(it) }
            .let { ok(it) }

    override fun getComments(postId: UUID): ResponseEntity<List<CommentVM>> =
        commentService.getComments(postId).map(commentMapper::toVM).let {
            ok(it)
        }

    override fun getComment(
        postId: UUID,
        commentId: UUID
    ): ResponseEntity<CommentVM> =
        commentService
            .getComment(postId, commentId)
            .let(commentMapper::toVM)
            .let { ok(it) }
}
