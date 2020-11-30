package com.example.myrxapplication.operators

import android.util.Log
import com.example.myrxapplication.MyTAG
import com.example.myrxapplication.Person
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/*
* fromArray operator : take an array of objects as input
*
* */

fun showFromArray() {
    val observable: Observable<Array<Person>> = Observable
        .fromArray(MyTAG.createPersonArray())
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    observable.subscribe(object : Observer<Array<Person>> {
        override fun onComplete() {
            Log.d(MyTAG.mainTag, "onCompleted")
        }

        override fun onSubscribe(d: Disposable) {
        }

        override fun onNext(t: Array<Person>) {
            for (person in t)
                Log.d(MyTAG.mainTag, "onNext : ${person.name}")
        }

        override fun onError(e: Throwable) {
            Log.e(MyTAG.mainTag, "onError :${e.message}")
        }
    })
}