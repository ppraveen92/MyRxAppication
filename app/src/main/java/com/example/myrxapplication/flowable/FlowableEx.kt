package com.example.myrxapplication.flowable

import android.util.Log
import com.example.myrxapplication.MyTAG
import io.reactivex.Flowable
import io.reactivex.FlowableSubscriber
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscription

/*
*
* Handling Backpressure with flowable with bufferstrategy
* */

fun main(args: Array<String>) {
    Flowable.range(0, 10000)
        .onBackpressureBuffer()
        .observeOn(Schedulers.computation())
        .subscribe(object : FlowableSubscriber<Int> {
            override fun onComplete() {
                Log.d(MyTAG.flowableTag, "onComplete")
            }

            override fun onSubscribe(s: Subscription) {
            }

            override fun onNext(t: Int?) {
                Log.d(MyTAG.flowableTag, "onNext: $t")
            }

            override fun onError(t: Throwable?) {
                Log.e(MyTAG.flowableTag, "onError: ${t?.message}")
            }
        })
}