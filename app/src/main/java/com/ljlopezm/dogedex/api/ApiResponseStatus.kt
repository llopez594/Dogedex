package com.ljlopezm.dogedex.api

import com.ljlopezm.dogedex.Dog

sealed class ApiResponseStatus {
    class Success(val dogList: List<Dog>): ApiResponseStatus()
    class Loading : ApiResponseStatus()
    class Error(val messageId: Int): ApiResponseStatus()
}