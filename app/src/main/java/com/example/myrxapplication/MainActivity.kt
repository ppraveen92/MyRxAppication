package com.example.myrxapplication

import com.example.myrxapplication.operators.*
import com.example.myrxapplication.transformOperator.showBuffer
import com.example.myrxapplication.transformOperator.showConcatMap
import com.example.myrxapplication.transformOperator.showFlatMap
import com.example.myrxapplication.transformOperator.showMap

/*
* Operator explained here. When is used to jump to that  1)create 2)Filter 3)FromArray 4)Callable 5)Iterable 6)Interval
* 7)Just 8)Range\n9)Take 10)TakeWhile 11)Timer 12)Buffer 13)ConcatMap 14)FlatMap 15)Map 16)Repeat
*
* */

class MainClass {
    fun main(args: Array<String>) {
        println("${R.string.user_input}")
        println("${R.string.please_enter_the_specified_number}")
        when (readLine()) {
            Constants.Create -> showCreate()
            Constants.Filter -> showFilter()
            Constants.FromArray -> showFromArray()
            Constants.Callable -> showCallable()
            Constants.Iterable -> showFromIterable()
            Constants.Interval -> showInterval()
            Constants.Just -> showJust()
            Constants.Range -> showrange()
            Constants.Take -> showTakeOperator()
            Constants.TakeWhile -> showTakeWhile()
            Constants.Timer -> showTimer()
            Constants.Buffer -> showBuffer()
            Constants.ConcatMap -> showConcatMap()
            Constants.FlatMap -> showFlatMap()
            Constants.Map -> showMap()
            Constants.Repeat -> showRepeat()
            else -> print("Unknown input")
        }
    }
}

object MyTAG {
    const val mainTag = "MAIN_TAG"
    const val flowableTag = "flowableTag"

    fun createPersonList(): MutableList<Person> {
        val mutableList: MutableList<Person> = mutableListOf()
        mutableList.add(Person("Syam", "engineer"))
        mutableList.add(Person("Manu", "doctor"))
        return mutableList
    }

    fun createPersonArray(): Array<Person> {
        return arrayOf(Person("Syam", "engineer"), Person("Manu", "doctor"))
    }

    fun createPerson(): Person = Person("Syam", "engineer")
}