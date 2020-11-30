package com.example.myrxapplication.disposable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myrxapplication.MyTAG
import com.example.myrxapplication.Person
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/*
* Disposable : Observer is no longer used , then it has to clear by adding the observer disposable into
*  CompositeDisposable and clear that list
*
* */
class DisaposableEx : AppCompatActivity() {
    var compositeDisposable: CompositeDisposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        compositeDisposable = CompositeDisposable()
        val observable: Observable<Person> = Observable
            .fromIterable(MyTAG.createPersonList())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
        observable.subscribe(object : Observer<Person> {
            override fun onComplete() {
                Log.d(MyTAG.mainTag, "onCompleted")
            }

            override fun onSubscribe(d: Disposable) {
                compositeDisposable?.add(d)
            }

            override fun onNext(t: Person) {
                Log.d(MyTAG.mainTag, "onNext : " + t.name)
            }

            override fun onError(e: Throwable) {
                Log.e(MyTAG.mainTag, "onError :" + e.message)
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable?.clear()

    }
}