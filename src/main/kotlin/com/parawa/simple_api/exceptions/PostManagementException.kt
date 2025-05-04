package com.parawa.simple_api.exceptions

import java.util.UUID

open class PostManagementException(message: String) : RuntimeException(message)

class PostNotFoundException(id: UUID) :
    PostManagementException("Post not found for id: $id")
