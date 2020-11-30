package com.example.myrxapplication.FlowableToObserable

import android.util.Log
import com.example.myrxapplication.MyTAG
import io.reactivex.*
import io.reactivex.disposables.Disposable
import org.reactivestreams.Subscription

/*
* Converting flowable to Observable and viceversa
*
* */

fun main(args: Array<String>) {
    val observable: Observable<Int> = Observable.just(1, 2, 3)
    val floawable: Flowable<Int> = observable.toFlowable(BackpressureStrategy.BUFFER)
    floawable.subscribe(object : FlowableSubscriber<Int> {
        override fun onComplete() {
            Log.d(MyTAG.flowableTag, "onComplete")
        }

        override fun onSubscribe(s: Subscription) {
        }

        override fun onNext(t: Int?) {
            Log.d(MyTAG.flowableTag, "onNext :$t")
        }

        override fun onError(t: Throwable?) {
        }
    })

    val convrtedObservable = floawable.toObservable()
    convrtedObservable.subscribe(object : Observer<Int> {
        override fun onComplete() {
            Log.d(MyTAG.flowableTag, "onComplete")
        }

        override fun onSubscribe(d: Disposable) {
        }

        override fun onNext(t: Int) {
            Log.d(MyTAG.flowableTag, "onNext $t")
        }

        override fun onError(e: Throwable) {
        }
    })
}