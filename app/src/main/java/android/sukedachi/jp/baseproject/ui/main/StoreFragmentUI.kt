package android.sukedachi.jp.baseproject.ui.main

import android.sukedachi.jp.baseproject.R
import android.sukedachi.jp.baseproject.data.model.Store
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

/**
 *
 * @author at-cuongcao.
 */
class StoreFragmentUI(storeInfoExpresses: MutableList<Store>) : AnkoComponent<StoreFragment> {
    internal lateinit var recyclerViewStores: RecyclerView
    internal val storeAdapter = StoreAdapter(storeInfoExpresses)

    override fun createView(ui: AnkoContext<StoreFragment>) = with(ui) {

        verticalLayout {
            lparams(matchParent, matchParent)
            backgroundResource = R.color.colorWhite

            recyclerViewStores = recyclerView {
                clipToPadding = false
                id = R.id.storeFragmentRecyclerViewStores
                layoutManager = LinearLayoutManager(context)
                adapter = storeAdapter
            }.lparams(matchParent, matchParent)
        }
    }
}
