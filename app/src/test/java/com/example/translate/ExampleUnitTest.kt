package com.example.translate

import org.junit.Test

import org.junit.Assert.*

fun main() {
    val answer = NetworkUtils.getTranslation("hello")
    println(answer)
}