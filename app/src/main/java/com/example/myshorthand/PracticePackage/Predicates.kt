package com.example.myshorthand.PracticePackage

import java.util.*

fun main() {
    filters()
    square()
    filterAndAdd()
    anotherMap()

}

fun filters() {
    val numbers = listOf(5F, 0.5F, 1F, 658F, 254F, 14F, 78F, 56F, .25F)
    val sorted = numbers.filter { it < 156} // Or numbers.filter { num -> num < 156 }
    println("The sorted numbers are ${sorted} ")
}

fun square() {
    val numbers = listOf(5F, 0.5F, 1F, 658F, 254F, 14F, 78F, 56F, .25F)
    val mapped = numbers.map { it * 2} // transforming data
    println("The square of numbers are ${mapped} ")
}
fun filterAndAdd() {
    val numbers = listOf(5F, 0.5F, 1F, 658F, 254F, 14F, 78F, 56F, .25F)
    val transformed = numbers.filter { it < 100 }.map { it * 2} // transforming data
    println("The mapped numbers are ${transformed}")
}

fun anotherMap() {
    var individualList = listOf(Individual("Akhil", 20),Individual("Anjana", 20),Individual("Amma", 20),
            Individual("Achan", 20))
    var individualNames = individualList.map { it.name }
    println("The individual names are ${individualNames}")
}

 class Individual(
        val name: String,
        val age: Int
)