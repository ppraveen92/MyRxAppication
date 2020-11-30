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
*
* timer operator : create Observable which emits an item after a span of time
*
* */

fun showTimer() {

    val observable: Observable<Long> = Observable
        .timer(3, TimeUnit.SECONDS)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    observable.subscribe(object : Observer<Long> {
        var time: Long = 0
        override fun onComplete() {
            Log.d(MyTAG.mainTag, "onCompleted")
        }

        override fun onSubscribe(d: Disposable) {
            time = System.currentTimeMillis() / 1000
            Log.d(MyTAG.mainTag, "onSubscribe : $time")
        }

        override fun onError(e: Throwable) {
            Log.e(MyTAG.mainTag, "onError : ${e.message}")
        }

        override fun onNext(t: Long) {
            Log.d(
                MyTAG.mainTag,
                "onNext: " + ((System.currentTimeMillis() / 1000) - time) + " seconds have elapsed"
            )
        }
    })
}