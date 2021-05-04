package com.example.mykotlin

// 10 제어 흐름

// when

fun main(array: Array<String>) {

    var value = 1

    when (value) {
        1 -> println("value is 1")
        2 -> println("value is 2")
        3 -> println("value is 3")
        else -> {
            println("I don't know value")
        }
    }

    var value4 = 1
    value4 = when (value4) {
        1 -> 10
        2 -> 20
        3 -> 30
        else -> 100
    }
    println(value4)
}