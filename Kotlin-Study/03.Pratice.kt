package com.example.mykotlin

var a : Int = 1 + 2 + 3 + 4 + 5 // 연산의 결과 값을 변수에 넣어 줄 수 있다.
var b = "1"
var c = b.toInt()

var d = b.toFloat()

var e = "Hun"
var f = "My name is $e Nice to meet you"

// Null
// - 존재 하지 않는다.

// var abc : Int = null
var abc1 : Int? = null // ? 을 넣어주면 Null 가질 수 있는 자료형이 된다.
var abc2 : Int = a + 3


fun main(array: Array<String>) {
    println(a)
    println(b)
    println(c)
    println(d)
    //println(e)
    println(f)

}