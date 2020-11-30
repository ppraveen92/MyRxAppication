package com.example.myrxapplication.transformOperator

import android.util.Log
import com.example.myrxapplication.MyTAG
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/*
*
* FlapMap Transformation Operator : transform the emitted item to observables
*
* */
fun showFlatMap() {
    val observable = Observable.just("Manu", "Sonu", "Anil")
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .flatMap { m ->
            Observable.just(m + " 2")
                .subscribeOn(Schedulers.io())
        }
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