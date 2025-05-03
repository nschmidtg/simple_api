package com.parawa.simple_api.mappers

import com.parawa.simple_api.dtos.CommentCreationDto
import com.parawa.simple_api.entities.Comment
import com.parawa.simple_api.entities.Post
import java.util.*
import openapi.generated.model.CreateCommentRequest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CommentMapperTest {
    private val commentMapper = CommentMapper()

    @Test
    fun toCommentCreationDto() {
        val postId = UUID.fromString("dd0f8f85-e9d7-44d5-8ec0-573647f51657")
        val createCommentRequest = CreateCommentRequest("Test Body")
        val commentCreationDto =
            commentMapper.toCommentCreationDto(postId, createCommentRequest)

        assertEquals(postId.toString(), commentCreationDto.postId.toString())
        assertEquals("Test Body", commentCreationDto.body)
    }

    @Test
    fun toEntity() {
        val postId = UUID.fromString("dd0f8f85-e9d7-44d5-8ec0-573647f51657")
        val post = Post(id = postId, title = "Test Title")
        val commentCreationDto = CommentCreationDto(postId, "Test Body")
        val comment = commentMapper.toEntity(commentCreationDto, post)

        assertEquals(postId.toString(), comment.post!!.id.toString())
        assertEquals("Test Body", comment.body)
    }

    @Test
    fun toVM() {
        val postId = UUID.fromString("dd0f8f85-e9d7-44d5-8ec0-573647f51657")
        val comment =
            Comment().apply {
                this.id = UUID.randomUUID()
                this.post = Post(id = postId, title = "Test Title")
                this.body = "Test Body"
            }
        val commentVM = commentMapper.toVM(comment)

        assertEquals(comment.id.toString(), commentVM.id.toString())
        assertEquals(postId.toString(), commentVM.postId.toString())
        assertEquals("Test Body", commentVM.body)
    }
}
