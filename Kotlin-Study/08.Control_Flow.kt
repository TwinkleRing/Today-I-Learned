package com.example.mykotlin

fun main(array: Array<String>) {
    val a : Int = 5
    val b : Int = 10

    println("1번")
    if (a > b) {
        println("a가 b 보다 크다")
    } else {
        println("a가 b 보다 작다")
    }
    println("3")


    if (a > b) println("a가 b 보다 크다")

    if (a > b) {
        println("a가 b 보다 크다")
    } else if (a < b) {
        println("a가 b 보다 작다")
    } else {
        println("a와 b는 같다")
    }

    // 값을 리턴하는 if 사용법
    val max = if (a > b) a else b

    println()
    println(max)
}