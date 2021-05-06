package com.example.mykotlin

fun main(array: Array<String>) {
    val tv = TV(listOf<String>("KBS","MBC","SBS"))

    tv.switch()

    println(tv.checkCurrentChannel())
    tv.channelUp()
    println(tv.checkCurrentChannel())
    tv.channelDown()
    println(tv.checkCurrentChannel())
    tv.channelDown()
    println(tv.checkCurrentChannel())
    tv.channelDown()
    println(tv.checkCurrentChannel())

    tv.switch()
}

class TV(val Channels : List<String>) {

    var onOrOff : Boolean = false
    var currentChannelNumber = 0
        set(value) {
            field = value
            if(field > 2) {
                field = 0
            }
            if (field < 0) {
                field = 2
            }
        }
        get() {
            println("호출되었습니다.")
            return field
        }

    fun switch() {
        onOrOff = !onOrOff

        if (onOrOff) {
            println("TV가 켜졌습니다.")
        } else {
            println("TV를 꺼졌습니다.")
        }
    }

    fun checkCurrentChannel() : String {
        return Channels[currentChannelNumber]
    }

    fun channelUp() {
        currentChannelNumber += 1
    }
    fun channelDown() {
        currentChannelNumber -= 1
    }
}