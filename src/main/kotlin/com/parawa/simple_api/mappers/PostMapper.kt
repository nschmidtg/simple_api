package com.parawa.simple_api.mappers

import com.parawa.simple_api.entities.Post
import openapi.generated.model.CreatePostRequest
import openapi.generated.model.PostVM
import org.springframework.stereotype.Component

@Component
class PostMapper {
    fun toEntity(createPostRequest: CreatePostRequest) =
        Post(
            title = createPostRequest.title,
        )

    fun toVM(post: Post) =
        PostVM(
            post.id.toString(),
            post.title,
        )
}
