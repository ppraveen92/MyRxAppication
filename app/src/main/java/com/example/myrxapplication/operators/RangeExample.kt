package com.example.myrxapplication.operators

import android.util.Log
import com.example.myrxapplication.MyTAG
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/*
* range Operator : used to create which transfer data within a range. It has min and max value to pass
*
* */
fun showrange() {
    val observable: Observable<Int> = Observable
        .range(1, 100)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    observable.subscribe(object : Observer<Int> {
        override fun onComplete() {
            Log.d(MyTAG.mainTag, "onCompleted")
        }

        override fun onSubscribe(d: Disposable) {
        }

        override fun onError(e: Throwable) {
            Log.e(MyTAG.mainTag, "onError : ${e.message}")
        }

        override fun onNext(t: Int) {
            Log.d(MyTAG.mainTag, "onNext : $t")
        }
    })
}