package com.example.mykotlin


fun main(array: Array<String>) {
    first()
    second(80)
    third(79)
    gugudan()
}
fun first() {
    val list1 = MutableList(9, { 0 })
    val list2  = MutableList(9, { true })

    for (i in 0..8) {
        list1[i] = i + 1
    }
    println(list1)

    list1.forEachIndexed { index, value ->
        if (value % 2 == 0)  list2[index] = true // 짝수
        else list2[index] = false   // 홀수
    }
    println(list2)
}

fun second(score : Int) : String {
    when (score) {
        in 90..100 -> {
            return "A"
        }
        in 80..89 -> {
            return "B"
        }
        in 70..79 -> {
            return "C"
        }
        else -> {
            return "F"
        }
    }
}

fun second2(score:Int) : String {
    var result :String = "F"
    when (score) {
        in 90..100 -> {
            result = "A"
        }
        in 80..89 -> {
            result = "A"
        }
        in 70..79 -> {
            result = "A"
        }
        else -> {
            result = "A"
        }
    }
    return result
}

fun third(number: Int) :Int {
    // 89 -> 8 + 9
    val a : Int = number / 10
    val b : Int = number % 10

    return a + b
}

fun gugudan() {
    for (x in 1..9) {
        for (y in 1..9) {
            println("$x x $y = ${x * y}")
        }
    }
}