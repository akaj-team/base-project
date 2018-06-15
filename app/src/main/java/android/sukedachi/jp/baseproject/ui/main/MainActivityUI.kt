package android.sukedachi.jp.baseproject.ui.main

import android.sukedachi.jp.baseproject.R
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.relativeLayout

class MainActivityUI : AnkoComponent<MainActivity> {

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        relativeLayout {
            lparams(matchParent, matchParent)
            id = R.id.mainActivityContainer
        }
    }
}
