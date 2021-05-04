package com.example.mykotlin

fun main(array: Array<String>) {
    val a : Int? = null
    val b : Int = 10
    val c : Int = 100

    if (a == null) {
        println("a is null")
    } else {
        println("a is not null")
    }

    if (b + c == 110) {
        println("b + c equal 110")
    } else {
        println("b + c is not 110")
    }

    // 엘비스 연산자
    var number : Int? = null
    var number2 = number ?: 10 // null이면 10이 들어간다
    println()
    println(number2)

    val num1 : Int = 10
    val num2 : Int = 20

    val max = if(num1 > num2) {
        num1
    } else if (num1 == num2) {
        num2
    } else {
        30
    }

    println(max)
}