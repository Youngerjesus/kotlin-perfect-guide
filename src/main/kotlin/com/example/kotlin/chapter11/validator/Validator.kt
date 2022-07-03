package com.example.kotlin.chapter11.validator

interface Validator {
    fun <T: Any> check(v: Any): Result<T>
}
