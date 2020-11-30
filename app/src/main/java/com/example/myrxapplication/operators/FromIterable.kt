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
* fromIterable operator: create oservables that emits an iterable of objects as List, ArrayList, Set ..
*
* */
fun showFromIterable() {
    val observable: Observable<Person> = Observable
        .fromIterable(MyTAG.createPersonList())
        .subscribeOn(Schedulers.io())
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
}