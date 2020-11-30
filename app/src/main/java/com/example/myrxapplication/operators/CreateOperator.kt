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
*
* Create Operator : which you can create  a single Observable
*
* */

fun showCreate() {

    val observable = Observable
        .create<Person> { emitter ->
            if (!emitter.isDisposed) {
                emitter.onNext(Person("Syam", "engineer"))
                emitter.onComplete()
            }
        }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    observable.subscribe(object : Observer<Person> {
        override fun onComplete() {
            Log.d(MyTAG.mainTag, "onCompleted")
        }

        override fun onSubscribe(d: Disposable) {
        }

        override fun onNext(t: Person) {
            Log.d(MyTAG.mainTag, "onNext ${t.name}")
        }

        override fun onError(e: Throwable) {
        }
    })


    val observable2 = Observable
        .create<Person> {
            it.let {
                for (task in MyTAG.createPersonList()) {
                    if (!it.isDisposed) {
                        it.onNext(task)
                    }
                }
                it.onComplete()
            }
        }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    observable2.subscribe(object : Observer<Person> {
        override fun onComplete() {
            Log.d(MyTAG.mainTag, "onCompleted")
        }

        override fun onSubscribe(d: Disposable) {
        }

        override fun onNext(t: Person) {
            Log.d(MyTAG.mainTag, "onNext ${t.name}")
        }

        override fun onError(e: Throwable) {
        }
    })
}