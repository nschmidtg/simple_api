package com.parawa.simple_api.mappers

import com.parawa.simple_api.dtos.CommentCreationDto
import com.parawa.simple_api.entities.Comment
import com.parawa.simple_api.entities.Post
import java.util.*
import openapi.generated.model.CommentVM
import openapi.generated.model.CreateCommentRequest
import org.springframework.stereotype.Component

@Component
class CommentMapper {
    fun toCommentCreationDto(
        postId: UUID,
        createCommentRequest: CreateCommentRequest
    ): CommentCreationDto =
        CommentCreationDto(
            postId = postId,
            body = createCommentRequest.body,
        )

    fun toEntity(commentCreationDto: CommentCreationDto, post: Post): Comment =
        Comment().apply {
            this.post = post
            this.body = commentCreationDto.body
        }

    fun toVM(comment: Comment): CommentVM =
        CommentVM(
            comment.id,
            comment.post!!.id,
            comment.body,
        )
}
