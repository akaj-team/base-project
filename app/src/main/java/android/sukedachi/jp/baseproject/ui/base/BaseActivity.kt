package android.sukedachi.jp.baseproject.ui.base

import android.support.v7.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Copyright © 2017 Asian Tech Co., Ltd.
 * Use this class to create base function for all activities in this app
 */
abstract class BaseActivity : AppCompatActivity() {

    private val subscription: CompositeDisposable = CompositeDisposable()

    protected fun addDisposables(vararg ds: Disposable) {
        ds.forEach { subscription.add(it) }
    }

    override fun onPause() {
        super.onPause()
        subscription.clear()
    }

    override fun onResume() {
        super.onResume()
        onBindViewModel()
    }

    /**
     * This function is used to define subscription
     */
    abstract fun onBindViewModel()
}
