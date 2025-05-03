package com.parawa.simple_api.dtos

import java.util.UUID

data class CommentCreationDto(
    val postId: UUID,
    val body: String,
)
