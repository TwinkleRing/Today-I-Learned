package com.example.mykotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// 01. Variable -> 변수


// 변수 선언
// var/val 변수명 = 값

// var = Variable 내 마음대로 원하는 것을 넣을 수 있는 상자
// val = Value 한번 넣으면 바꿀 수 없는 상자

var num = 10
var hello = "hello"
var point = 3.4

val fix = 20


fun main(args:Array<String>) {

    println(num)
    println(hello)
    println(point)
    println(fix)

    num = 100
    hello = "Good Bye"
    point = 10.4

    println(num)
    println(hello)
    println(point)


    //  fix = 500 -> value는 값을 바꿀 수 없다.

    // Variable or Value ????
    // - 1. 변하지 않을 값이라면 val
    // - 2. 변할지 안변할지 잘 모르겠다! -> var
}