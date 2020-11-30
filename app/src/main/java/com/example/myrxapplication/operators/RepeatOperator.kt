package com.example.myrxapplication.operators

import android.util.Log
import com.example.myrxapplication.MyTAG
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/*
* repeat Operator : used to create observable which transfers data for the
* number of times mentioned in repeat operator
*
* */
fun showRepeat() {
    val observable: Observable<Int> = Observable
        .range(1, 5)
        .repeat(2)
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