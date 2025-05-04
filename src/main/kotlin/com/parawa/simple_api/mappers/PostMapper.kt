package com.parawa.simple_api.mappers

import com.parawa.simple_api.dtos.PostCreationDto
import com.parawa.simple_api.entities.Post
import openapi.generated.model.CreatePostRequest
import openapi.generated.model.PostVM
import org.springframework.stereotype.Component

@Component
class PostMapper {
    fun toDto(createPostRequest: CreatePostRequest) =
        PostCreationDto(
            title = createPostRequest.title,
        )

    fun toEntity(postCreationDto: PostCreationDto) =
        Post(
            title = postCreationDto.title,
        )

    fun toVM(post: Post) =
        PostVM(
            post.id.toString(),
            post.title,
        )
}
