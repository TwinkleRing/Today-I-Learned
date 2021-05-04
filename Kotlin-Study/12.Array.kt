package com.example.mykotlin

// 12. 배열

// 배열이 필요한 이유
// - 값들의 그룹이 필요할 때

fun main(array: Array<String>) {
    // 배열 생성하는 방법
    var array1 = arrayOf<Int>(1, 2, 3, 4, 5)

    println(array1 is Array)

    var array2 = arrayOf(1, 2, 3.5, "Hello")


    // 배열의 값을 꺼내는 방법(1)
    println(array1.get(3))

    // 배열의 값을 바꾸는 방법(1)
    array1.set(0, 100)
    println(array1[0])

    array1[2] = 200
    println(array1[2])

}