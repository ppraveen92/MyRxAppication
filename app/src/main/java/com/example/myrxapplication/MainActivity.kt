package com.example.myrxapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myrxapplication.MyTAG.createPersonList
import com.example.myrxapplication.operators.*
import com.example.myrxapplication.transformOperator.showBuffer
import com.example.myrxapplication.transformOperator.showConcatMap
import com.example.myrxapplication.transformOperator.showFlatMap
import com.example.myrxapplication.transformOperator.showMap
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers.*

/*
* Just an example for observable,observer and operator with fromiteratable operator
*
* */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val observable: Observable<Person> = Observable
            .fromIterable(createPersonList())
            .subscribeOn(io())
            .observeOn(AndroidSchedulers.mainThread())

        observable.subscribe(object : Observer<Person> {
            override fun onComplete() {
                Log.d(MyTAG.mainTag, "onCompleted")
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: Person) {
                Log.d(MyTAG.mainTag, "onNext : " + t.name)
            }

            override fun onError(e: Throwable) {
                Log.e(MyTAG.mainTag, "onError :" + e.message)
            }
        })
        showCreate()
        showFilter()
        showFromArray()
        showCallable()
        showFromIterable()
        showInterval()
        showJust()
        showrange()
        showRepeat()
        showTakeOperator()
        showTakeWhile()
        showTimer()
        showBuffer()
        showConcatMap()
        showFlatMap()
        showMap()
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