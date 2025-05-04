package com.parawa.simple_api.exceptions

import java.util.UUID

open class CommentManagementException(message: String) :
    RuntimeException(message)

class CommentNotFoundException(id: UUID, postId: UUID) :
    CommentManagementException(
        "Comment not found for id: $id and postId: $postId"
    )
