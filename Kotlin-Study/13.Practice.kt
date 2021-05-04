package com.example.mykotlin

fun main(array: Array<String>) {
    var array = arrayOf<Int>(1,2,3)

    // get, set
    val number = array.get(0)
    println(number)

    // array의 Bounds
    // - 처음 만들때 결정 된다.

    // Array를 만드는 방법(3)
    var a1 = intArrayOf(1, 2, 3)
    val a2 = charArrayOf('b', 'c', 'e') // char -> ''
    val a3 = doubleArrayOf(1.2,100.356)
    var a5 = booleanArrayOf(true, false, true)


    // Array를 만드는 방법(4)
    var a6 = Array(10, { 0 }) // lambda를 활용하는 방법
    var a7 = Array(5, {1;2;3;4;5})


}