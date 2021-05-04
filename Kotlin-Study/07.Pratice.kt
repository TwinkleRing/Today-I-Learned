package com.example.mykotlin

fun main(array: Array<String>) {
    var a = 10 + 1
    var b = 10 - 1
    var c = 1 * 9
    var d = 20 / 3
    var e = 20 % 4

    println(a)
    println(b)
    println(c)
    println(d)
    println(e)

    val f = 5
    a += 10

    b -= 10
    c *= 30

    e %= 2
    d /= 4

    a += 1
    a++
    b--

    println()
    println(a)
    println(b)
    println(c)
    println(d)
    println(e)

    // 비교 연산자

    var g = a > b
    var h = a == b
    var i = !h
    println()
    println(g)
    println(h)
    println(i)

    // 논리 연산자

    var j = h && i
    var k = h || i



}