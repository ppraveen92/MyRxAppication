package com.example.myrxapplication.transformOperator

import android.util.Log
import com.example.myrxapplication.MyTAG
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/*
* Map Operator : transformation operator which transform each emitted item by applying function on it
*
* */

fun showMap() {
    val observable = Observable.just("sam", "manu", "sanu")
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .map { "$it 2" }
    observable.subscribe(object : Observer<String> {
        override fun onComplete() {
            Log.d(MyTAG.mainTag, "onComplete")
        }

        override fun onSubscribe(d: Disposable) {
        }

        override fun onNext(t: String) {
            Log.d(MyTAG.mainTag, "onNext : $t")
        }

        override fun onError(e: Throwable) {
            Log.d(MyTAG.mainTag, "onError")
        }
    })
}