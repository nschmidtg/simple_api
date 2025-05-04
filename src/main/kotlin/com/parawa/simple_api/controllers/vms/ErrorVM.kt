package com.parawa.simple_api.controllers.vms

data class ErrorVM(
    val code: String,
    val description: String? = null,
    val errors: List<String> = emptyList(),
) {}
