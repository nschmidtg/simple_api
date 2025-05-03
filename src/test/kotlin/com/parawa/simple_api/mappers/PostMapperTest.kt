package com.parawa.simple_api.mappers

import com.parawa.simple_api.entities.Post
import java.util.*
import openapi.generated.model.CreatePostRequest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PostMapperTest() {
    private val postMapper = PostMapper()

    @Test
    fun toEntity() {
        val createPostRequest = CreatePostRequest("Test Title")
        val post: Post = postMapper.toEntity(createPostRequest)

        assertEquals("Test Title", post.title)
    }

    @Test
    fun toVM() {
        val id = UUID.fromString("dd0f8f85-e9d7-44d5-8ec0-573647f51657")
        val post = Post(id = id, title = "Test Title")
        val postVM = postMapper.toVM(post)

        assertEquals(id.toString(), postVM.id.toString())
        assertEquals("Test Title", postVM.title)
    }
}
