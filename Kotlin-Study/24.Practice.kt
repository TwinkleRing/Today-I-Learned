package com.example.mykotlin

fun main(array: Array<String>) {
    val night = Night(20, 4)
    val monster = Monster(15, 5)

    night.attack(monster)
    monster.attack(night)

}

class Night(private var hp: Int, private var power : Int) {

    fun attack(monster: Monster) {
        monster.defense(power)
    }

    fun defense(damage :Int) {
        hp -= damage
        if (hp > 0) {
            heal()
            println("기사의 현재 체력은 $hp 입니다.")
        } else println("기사가 죽었습니다.")
    }

    private fun heal() {
        // 아무때나 heal 사용하는게 아니라
        // 공격을 당했을 때 죽지 않았다면 heal을 한다. -> private 접근 제어자
        hp += 3
    }
}
class Monster(private var hp : Int, private var power : Int) {
    fun attack(night: Night) {
        night.defense(power)

    }

    fun defense(damage : Int) {
        hp -= damage
        if (hp > 0) println("몬스터 현재 체력은 $hp 입니다.")
        else println("몬스터가 죽었습니다.")

    }
}