package com.example.mykotlin

// 04. Function
// - 함수란
//         - 어떤 Input 을 넣어주면 어떤 Output 나오는 것

// - 함수를 선언하는 방법

// fun 함수명 (변수명 : 타입, 변수명 : 타입....) : 반환형 {
//    함수의 내용
//    return 반환값
// }

fun plus(first : Int, second : Int) : Int {
    val result: Int = first + second
    return result
}

// - 디폴트 값을 갖는 함수 만들기
fun plusFive(first : Int, second : Int = 5): Int {
    val result: Int = first + second
    return result
}

// - 반환 값이 없는 함수 만들기
fun printPlus(first : Int, second : Int) : Unit {
    val result : Int = first + second
    println(result)
}

// - 간단하게 함수를 선언하는 방법

fun plusShort(first: Int, second: Int) = first + second

// - 가변인자를 갖는 함수를 선언하는 방법
fun plusMany(vararg numbers : Int){
    for (number in numbers) {
        println(number)
    }
}

fun main(array: Array<String>){
    val result = plus(10, 20)
    println(result)

    val result2 = plus(second = 100, first = 10)
    println(result2)

    println()

    val result3 = plusFive(10, 20)
    val result4 = plusFive(10)

    println(result3)
    println(result4)

    println()
    printPlus(19, 20)

    val result6 : Int = plusShort(50, 50)
    println(result6)

    println()

    plusMany(1,2,3)

}

