package com.example.myrxapplication.operators

import android.util.Log
import com.example.myrxapplication.MyTAG
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/*
* just Operator : used to create single observables to emit  data set of 10 Strings
*
* */
fun showJust() {
    val observable: Observable<String> = Observable.just("1", "2")
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    observable.subscribe(object : Observer<String> {
        override fun onComplete() {
            Log.d(MyTAG.mainTag, "onCompleted")
        }

        override fun onSubscribe(d: Disposable) {
        }

        override fun onError(e: Throwable) {
            Log.e(MyTAG.mainTag, "onError : ${e.message}")
        }

        override fun onNext(t: String) {
            Log.d(MyTAG.mainTag, "onNext : $t")
        }
    })
}