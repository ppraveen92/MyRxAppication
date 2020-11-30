package com.example.myrxapplication.transformOperator

import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/*
*
* ConcatMap Transformation Operator : Same like flatap that transform emitted item to observables
* Here the order maintained since it wait for each observables to complete
*
* */
fun getModifiedObservable(integer: Int): Observable<Int> {
    return Observable.create(ObservableOnSubscribe<Int> { emitter ->
        emitter.run {
            onNext(integer * 2)
            onComplete()
        }
    })
        .subscribeOn(Schedulers.io())
}

fun showConcatMap() {
    Observable.just(1, 2, 3, 4, 5, 6)
        .concatMap { getModifiedObservable(it) }
        .subscribeOn(Schedulers.io())
        .subscribe(object : Observer<Int> {
            override fun onComplete() {
                println("onComplete")
            }

            override fun onSubscribe(d: Disposable) {
                println("onSubscribe")
            }

            override fun onNext(t: Int) {
                println("onNext: $t")
            }

            override fun onError(e: Throwable) {
            }
        })
}

