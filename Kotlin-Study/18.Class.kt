package com.example.mykotlin

// 18. Class

// OOP -> 객체 지향 프로그래밍

// "객체"란 뭘까?
// - 이름이 있는 모든 것

// 객체지향 프로그래밍 문제 해결 방법
// - 객체를 만들어서, 객체에게 일을 시켜서 문제를 해결한다.
// - 선수, 심판, 경기장, 관중 -> 축구 게임

// 객체를 만드는 방법
// - 설명서가 있어야 합니다. -> 클래스

fun main(array: Array<String>) {
    // 클래스를 통해서 실체를 만드는 방법
    // 인스턴스화 -> 인스턴스(실제 생성한 객체) 생성
    // Car("v8 engine", "big")

    val bigCar = Car("v8 engine", "big")

    // 우리가 만든 클래스는 자료형이 된다.
    val bigCar1 : Car = Car("v8 engine", "big")

    val MyCar : Tesla = Tesla("good engine", "big", "black" )

    // RunableCar.ride() -> 불가능! 인스턴스화해서 실제 인스턴스를 만들어야 한다.
    val runableCar : RunableCar = RunableCar("simple engine", "big")
    runableCar.ride()
    runableCar.drive()
    runableCar.navigation("seoul")


    // 인스턴스의 멤버 변수에 접근 하는 방법
    val runableCar2 : RunableCar2 = RunableCar2("nice engine" , "long body")
    println(runableCar2.body)
    println(runableCar2.engine)

    println()

    val testClass = TestClass()

    testClass.test(1)
    testClass.test(1, 2)

}
// 클래스(설명서) 만드는 방법 (1)
class Car(var engine : String, var body : String) {

}

// 클래스 만드는 방법 (2)
class Tesla {
    var engine : String = ""
    var body : String = ""
    var door : String = ""

    constructor(engine: String, body: String, door: String) {
        //println(engine)
        //println(body)
        //println(door)
        this.engine = engine
        this.body = body
        this.door = door
    }
}


// 클래스 만드는 방법 (3) -> 1번 방법의 확장
class Ford constructor(engine : String, body : String) {
    var wheel : String = ""

    // 생성자
    constructor(engine: String, body: String, wheel : String) : this(engine, body) {
        this.wheel = wheel
    }
}

// 클래스 만드는 방법 (4) -> 2번 방법의 확장
class Car3 {
    var engine : String = ""
    var body : String = ""
    var door : String = ""

    constructor(engine: String, body: String) {
        this.engine = engine
        this.body = body
    }

    constructor(engine: String, body: String, door: String) {
        this.engine = engine
        this.body = body
        this.door = door
    }

}

class RunableCar(engine: String, body: String) {
    fun ride() {
        println("탑승하였습니다.")
    }

    fun drive() {
        println("달립니다!")
    }

    fun navigation(destination : String) {
        println("$destination 으로 목적지가 설정되었습니다.")
    }
}

class RunableCar2 {

    // 멤버 변수
    var engine :String = ""
    var body : String = ""

    // 생성자
    constructor(engine: String, body: String) {
        this.engine = engine
        this.body = body
    }

    // 인스턴스화될 때 가장 먼저 호출되는 생성자
    init {
        // 클래스 초기 셋팅
        println("RunnableCar2가 만들어 졌습니다.")
    }

    // 클래스의 기능
    fun ride() {
        println("탑승하였습니다.")
    }

    fun drive() {
        println("달립니다!")
    }

    fun navigation(destination : String) {
        println("$destination 으로 목적지가 설정되었습니다.")
    }
}


// 오버로딩 -> 이름이 같지만 받는 파라미터가 다른 함수
class TestClass() {

    val a : Int = 10
    val b : Int = 12

    fun test(a : Int) {
        println("up")

    }
    fun test(a : Int, b : Int) {
        println("down")

    }

}