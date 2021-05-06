package com.example.mykotlin

// 1) 사칙 연산을 수행할 수 있는 클래스
// 2) 은행 계좌 만들기
// 3) TV 클래스


fun main(array: Array<String>){
    val calculator1 = Calculator1()
    println(calculator1.plus(4, 5))
    println(calculator1.minus(4, 5))
    println(calculator1.divide(4, 5))
    println(calculator1.multiply(4, 5))

    val calculator2 = Calculator2()
    println(calculator2.divide(10,2,3))
    println(calculator2.minus(10,1,2,4))

    val calculator3 = Calculator3(3)
    println(calculator3.plus(5).minus((5))) // Calculator3(8).minus(5) => 3

}

class Calculator1() {
    fun plus(a : Int, b : Int) : Int {
        return a + b
    }
    fun minus(a : Int, b : Int) : Int {
        // 먼저 들어온 수에서 뒤에 들어온 수를 뺀다.
        return a - b
    }
    fun multiply(a : Int, b : Int) : Int {
        return a * b
    }
    fun divide(a : Int, b : Int) : Int {
        return a / b
    }
 }

class Calculator2() {
    fun plus(vararg  numbers : Int) : Int {
        var result : Int = 0
        numbers.forEach {
            result += it
        }
        return result
    }
    fun minus(vararg  numbers : Int) : Int {
        var result : Int = numbers[0]
        for (i in 0 until numbers.size) {
            if (i != 0) {
                result -= numbers[i]
            }
        }
        return result
    }
    fun multiply(vararg  numbers : Int) : Int {
        var result : Int = 1
        numbers.forEach {
            if (it != 0) {
                result *= it
            }
        }
        return result
    }
    fun divide(vararg  numbers : Int) : Int {
        var result : Int = numbers[0]
        numbers.forEachIndexed { index, value ->
            if (index != 0 && value != 0) {
                    result /= value
            }
        }
        return result
    }
}

class Calculator3(val initialValue : Int) {
    fun plus(number: Int) : Calculator3 {
        val result = this.initialValue + number
        return Calculator3(result)
    }
    fun minus(number : Int) :Calculator3 {
        val result = this.initialValue - number
        return Calculator3(result)
    }
    fun multiply(number : Int) : Calculator3 {
        val result = this.initialValue * number
        return Calculator3(result)
    }
    fun divide(number : Int) : Calculator3 {
        val result = this.initialValue / number
        return Calculator3(result)
    }
}