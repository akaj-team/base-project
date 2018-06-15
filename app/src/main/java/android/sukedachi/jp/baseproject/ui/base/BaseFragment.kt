package android.sukedachi.jp.baseproject.ui.base

import android.support.v4.app.Fragment
import io.reactivex.disposables.CompositeDisposable

/**
 * Copyright © 2017 Asian Tech Co., Ltd.
 * Use this class to create base function for all fragments in this app
 */
abstract class BaseFragment : Fragment() {

    private val subscription: CompositeDisposable = CompositeDisposable()

    override fun onResume() {
        super.onResume()
        onBindViewModel()
    }

    override fun onPause() {
        super.onPause()
        subscription.clear()
    }

    /**
     * This function is used to define subscription
     */
    abstract fun onBindViewModel()

}
