package com.example.mykotlin

// 25. 상속
// - 동일한 메서드를 클래스마다 각각 다시 구현해야한다. -> 중복, 불편함

// - 상속은 부모로부터 기능 및 멤버 변수(설명서)를 물려받는다.

fun main(array: Array<String>) {
    val superCar100 :SuperCar100 = SuperCar100()
    println(superCar100.drive())
}

// 부모 : Car100
// 자식 : SuperCar1, Bus1, Truck1
open class Car100() { // private를 open으로 바꿔줘야 상속이 가능하다.
    open fun drive() : String{
        return "달린다."
        //println("달린다")
    }
    fun stop() {

    }
}

class SuperCar100() : Car100() {
    // 오버라이딩
    override fun drive() : String {
        val run = super.drive()
        return "빨리 $run"
        //println("빨리 달린다")
        //super.drive() // super은 부모를 가리킨다.

    }
}
class Truck1() : Car100() {

}
class Bus1() : Car100() {

}