package com.example.mykotlin

// 16. Iterable

fun main(array: Array<String>) {
    val a = mutableListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9)

    // 반복하는 방법 (1)

    for (item in a) {
        println(item)
    }

    for (item in a) {
        if (item == 5) {
            println("item is Five")
        } else {
            println("item is not  Five")
        }
    }

    println()

    // 반복하는 방법 (2)
    for ((index, item) in a.withIndex()) {
        println("index : " + index + " value : " + item)
    }

    println()

    // 반복하는 방법 (3)
    a.forEach {
        println(it)
    }

    // 반복하는 방법 (4)
    a.forEach { item ->
        println(item)
    }

    println()

    // 값과 인덱스 같이 반복
    a.forEachIndexed { index, item ->
        println("index : " + index + " value : " + item);
    }

    println()

    // 반복하는 방법 (6)
    println(a.size)

    // until은 마지막을 포함 하지 않는다. 0부터 8까지
    for (i in 0 until a.size) {
        println(a.get(i))
    }

    for (i in 0 until a.size step (2)) {
        println(a.get(i))
    }

    for (i in a.size - 1 downTo (0)) {
        println(a.get(i))
    }

    for (item in 0..10) {
        // .. 은 마지막을 포함시킨다.
        println(item)
    }

    // 반복하는 방법 (11)
    var b : Int = 0
    var c : Int = 4

    while (b < c) {
        b++ // while문을 정지 시키기 위한 코드
        println("B")
    }

    println()

    do {
        println("hello")
    } while (b < c)

}