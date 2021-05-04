package com.example.mykotlin

import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.N)

fun main(array: Array<String>) {

    val a = mutableListOf<Int>(1,2,3)
    a.add(4)
    println(a)
    a.add(0,100)
    println(a)

    a.set(0, 200)
    println(a)

    a.removeAt(1)
    println(a)

    println()

    val b = mutableSetOf<Int>(1, 2, 3, 4)
    b.remove(2)
    println(b)

    println()

    val c = mutableMapOf<String, Int>("one" to 1)
    c.put("two", 2)
    println(c)

    c.replace("two", 3)
    println(c)

    println(c.keys)
    println(c.values)

    c.clear()
    println(c)

}