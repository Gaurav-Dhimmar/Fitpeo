package com.myapplication.app.service.model.responses

enum class ErrorCode {
    UNAUTHORIZED,
    NOT_FOUND,
    NO_NETWORK,
    BAD_RESPONSE,
    UNKNOWN
}

data class ErrorResponse(val code : ErrorCode = ErrorCode.UNKNOWN,
                         val error : String = "",
                         val message : String = "") {
    override fun toString(): String {
        return code.name + " - " + error + ": " + message
    }
}