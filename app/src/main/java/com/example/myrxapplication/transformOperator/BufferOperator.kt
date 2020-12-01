package com.example.myrxapplication.transformOperator

import android.util.Log
import com.example.myrxapplication.MyTAG
import com.example.myrxapplication.MyTAG.createPersonList
import com.example.myrxapplication.Person
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/*
* Buffer Operator: transform the items in buffered manner
*
* */
fun showBuffer() {
    val observable: Observable<Person> = Observable
        .fromIterable(createPersonList())
        .subscribeOn(Schedulers.io())

    observable.buffer(2)
        .subscribe(object : Observer<MutableList<Person>> {
            override fun onComplete() {

            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: MutableList<Person>) {
                Log.d(MyTAG.mainTag, "Bundles ...")
                for (person in t) {
                    Log.d(MyTAG.mainTag, "onNext : ${person.name}")
                }
            }

            override fun onError(e: Throwable) {

            }
        })
}