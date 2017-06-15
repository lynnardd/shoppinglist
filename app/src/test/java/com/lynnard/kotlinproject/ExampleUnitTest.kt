package com.lynnard.kotlinproject

import org.junit.Test
import org.junit.Assert.*
import java.util.Collections.copy

/**
 * Example local unit test, which will execute on the development machine (host).

 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class ExampleUnitTest {

/*
    fun sum(a: Int, b: Int) = a + b

    fun printSum() = "sum of 1 and 1 is ${sum(1, 1)}"

    //fun parseInt(string: String) = string.toInt()

    /*fun printProduct(arg1: String, arg2: String) {
        val x = parseInt(arg1)
        val y = parseInt(arg2)

        // Using `x * y` yields error because they may hold nulls.
        if (x != null && y != null) {
            // x and y are automatically cast to non-nullable after null check
            println(x * y)
        }
        else {
            println("either '$arg1' or '$arg2' is not a number")
        }
    }*/

    @Test
    @Throws(Exception::class)
    fun addition_isCorrect() {
        assertEquals(4, (2 + 2).toLong())
    }


    @Test
    @Throws(Exception::class)
    fun sumTest() {
        assertEquals(7, sum(5, 2))
    }

    @Test
    @Throws(Exception::class)
    fun printSumTest() {
        assertEquals("sum of 1 and 1 is 2", printSum())
    }


    fun strlen(string: Any): Int? {
        if (string is String)
            return string.length

        return null
    }

    @Test
    @Throws(Exception::class)
    fun strlenTest() {
        assertEquals(3, strlen("223"))
    }

    @Test
    @Throws(Exception::class)
    fun classTest() {
        data class Person(val name: String, val age: Int) {
            val personName = name
            val personAge = age

            constructor(age: Int) : this("jonas", age)
            constructor() : this("nard", 6)

        }


        val person = Person("ysa", 20)

        val clone = person.copy()

        val (name, age) = clone

        assertEquals(clone, person)
        assertEquals(name, person.name)


    }

*/
    @Test
    @Throws(Exception::class)
    fun stringTest() {

        assertEquals(true, "hello".contains("LL", true))
    }

    @Test
    @Throws(Exception::class)
    fun dataClassTest() {

        data class PersonName(val name: String)
        data class Age(val age: String)

        data class person(val name: PersonName, val age: Age)

        val bogart = person(PersonName("bogart"), Age("999"))

        val clone = bogart.copy()
        assertEquals(clone.name, PersonName("bogart"))
        assertEquals(clone.age, Age("999"))

    }
}