package com.example.mykotlin

// 변수의 접근 범위
// 1. 전역 변수
// 2. 지역 변수

var number100 : Int = 10 // 전역 변수

fun main(array: Array<String>) {
    println(number100)

    val test = Test("홍길동")
    test.testFun()
    test.name

}


class Test(var name : String) {
    fun testFun() {
        var birth : String = "1924/3/11"
        name = "홍길동"
        number100 = 1000
    }


    fun testFun2() {
        name
        //birth -> 사용 불가
    }
}