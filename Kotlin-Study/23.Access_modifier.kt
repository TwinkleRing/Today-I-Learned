package com.example.mykotlin

// 23. 접근 제어자
fun main(array: Array<String>) {
    val testAccess : TestAccess = TestAccess("아무개")
    testAccess.test()
    //println(testAccess.name)

    //testAccess.name = "무아개"
    //println(testAccess.name)

    val reward : Reward = Reward()
    reward.rewardAmount = 2000 // 마음대로 값을 변경시킬 수 있다.
}

class Reward() {
    var rewardAmount : Int = 1000
}

class TestAccess {
    private var name : String = "홍길동" // 현재 클래스 외부에서 변경할 수 없게 private 접근 제어자를 설정해준다.

    constructor(name : String) {
        this.name = name
    }

    fun test() {
        println("테스트")
    }
}