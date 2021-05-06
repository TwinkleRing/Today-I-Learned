package com.example.mykotlin

// 29. Generic(제너릭)

// 목적 : 다양한 타입의 객체들을 다루는 메서드나 컬렉션 클래스에서 컴파일 시에 타입을 체크해주는 기능

// 즉, 타입을 체크해주는 기능

fun main(array :Array<String>) {
    // 제너릭을 사용하지 않은 경우1
    val list1 = listOf(1,2,3,"가")

    //val n : String = list1[2] // error
    val n : String = list1[2].toString() // 형변환(타입 변환)

    // 제너릭을 사용하는 경우 -> 타입이 안전하다.
    val list2 = listOf<String>("a","b","c")
    val c : String = list2[2] // String 이라는 것을 보장 받는다. <String>

    // 강한 타입을 체크할 수 있다.
    val list3 = listOf(1,2,3,4,"가","나",3.0)
    // val list4 = listOf<Int>(1,2,3,"가") // syntax error

    // 제너릭을 사용하지 않은 경우2
    val list5 = listOf(1, 2, 3, "가") // -> Any 타입
    // 부모 : Any
    // 자식 : String, Int, Float

}