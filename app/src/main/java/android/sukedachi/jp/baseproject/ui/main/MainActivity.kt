package android.sukedachi.jp.baseproject.ui.main

import android.os.Bundle
import android.sukedachi.jp.baseproject.R
import android.sukedachi.jp.baseproject.ui.base.BaseActivity
import org.jetbrains.anko.setContentView

class MainActivity : BaseActivity() {

    private lateinit var ui: MainActivityUI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = MainActivityUI()
        ui.setContentView(this)
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.mainActivityContainer, StoreFragment())
                .commit()
    }

    override fun onBindViewModel() = Unit
}
