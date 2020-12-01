package com.example.myrxapplication.operators

import android.annotation.SuppressLint
import android.util.Log
import com.example.myrxapplication.MyTAG.createPerson
import com.example.myrxapplication.Person
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/*
* fromCallable operator : to execute block of code and return that object
*
* */

@SuppressLint("CheckResult")
fun showCallable() {
    val observable = Observable.fromCallable<Person> {
        return@fromCallable createPerson()
    }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    observable.subscribe(object : Observer<Person> {
        override fun onComplete() {
            Log.d("FromCallableExample", "Complete")
        }

        override fun onSubscribe(d: Disposable) {
        }

        override fun onNext(t: Person) {
            Log.d("FromCallableExample", "item : ${t.name}")
        }

        override fun onError(e: Throwable) {
        }
    })
}

