package com.example.mykotlin



fun plusThree(first : Int, second: Int, third : Int) : Int {
    return first + second + third
}

fun minusThree(first : Int, second : Int, third : Int) = first - second - third

fun multiplyThree(first : Int, second : Int, third: Int = 1)  : Int {
    var mul : Int = first * second * third
    return mul
}

// 내부 함수
// - 함수 안에 함수가 있다!
fun showMyPlus(first: Int, second: Int) : Int {
    println(first)
    println(second)

    fun plus(first: Int, second: Int) : Int {
        return first + second
    }

    return plus(first, second)
}

fun main(array: Array<String>) {
    val result = plusThree(1, 2, 3)
    println(result)

    val result2 = minusThree(10,2,1)
    println(result2)

    val result3 = multiplyThree(2, 2)
    println(result3)
}