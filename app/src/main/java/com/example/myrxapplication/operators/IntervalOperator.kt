package com.example.myrxapplication.operators

import android.util.Log
import com.example.myrxapplication.MyTAG
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/*
*  interval operator :creates Observable that emits an infinite sequence of ascending integers,
*  with a constant interval of time. Here used takewhile operator to have the condition
*
* */
fun showInterval() {

    val observable: Observable<Long> = Observable
        .interval(1, TimeUnit.SECONDS)
        .subscribeOn(Schedulers.io())
        .takeWhile { it <= 5 }
        .observeOn(AndroidSchedulers.mainThread())

    observable.subscribe(object : Observer<Long> {
        override fun onComplete() {
            Log.d(MyTAG.mainTag, "onCompleted")
        }

        override fun onSubscribe(d: Disposable) {
        }

        override fun onError(e: Throwable) {
            Log.e(MyTAG.mainTag, "onError : ${e.message}")
        }

        override fun onNext(t: Long) {
            Log.d(MyTAG.mainTag, "onNext : $t")
        }
    })
}