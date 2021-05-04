package com.example.mykotlin

// 11. 제어흐름 실습

fun main(array : Array<String>) {

    var value : Int? = null

    when(value) {
        null -> println("value is null")
        else -> println("value is not null")

    }

    val value2 : Boolean? = null
    // when 구문은 조건으로 갖는 값의 모든 경우에 대응 해주는 것이 좋다.

    when(value2) {
        true -> println("")
        false -> println("")
        null -> println("")
    }
    // 값을 리턴하는 when 구문의 경우 반드시 값을 리턴해야 한다.
    var value3 = when(value2) { // null 조건도 반드시 포함시켜야 한다.
        true -> 1
        false -> 3
        null -> 4
    }
    // when의 다양한 조건식 (1)
    var value6 : Int = 10
    when (value6) {
        is Int -> {
            println("value6 is Int")
        }
        else -> {
            println("value6 is not Int")
        }
    }

    // when의 다양한 조건식 (2)
    var value7 : Int = 87
    when (value7) {
        in 60..70 -> {
            println("value is in 60-70")
        }
        in 70..80 -> {
            println("value is in 70-80")
        }
        in 80..90 -> {
            println("value is in 80-90")
        }
    }
}