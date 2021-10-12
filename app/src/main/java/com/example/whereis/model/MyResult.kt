package com.example.whereis.model

import java.lang.Exception

sealed class MyResult<out R> {

    data class Success<T>(val data: T): MyResult<T>()
    data class Error(val e: Exception): MyResult<Nothing>()
}
