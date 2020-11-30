package com.example.myrxapplication.operators

import android.util.Log
import com.example.myrxapplication.MyTAG
import com.example.myrxapplication.MyTAG.createPersonList
import com.example.myrxapplication.Person
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/*
*
* Filter Operators : items will be transfered only if the condition satisfies
*
* */
fun showFilter() {
    val observable: Observable<Person> = Observable
        .fromIterable(createPersonList())
        .filter { it.name == "sam" }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    observable.subscribe(object : Observer<Person> {
        override fun onComplete() {

        }

        override fun onSubscribe(d: Disposable) {
        }

        override fun onNext(t: Person) {
            Log.d(MyTAG.mainTag, "onNext : ${t.name}")
        }

        override fun onError(e: Throwable) {
        }
    })
}