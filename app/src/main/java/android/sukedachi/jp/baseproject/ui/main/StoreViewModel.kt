package android.sukedachi.jp.baseproject.ui.main

import android.sukedachi.jp.baseproject.data.source.StoreRepository

/**
 *
 * @author at-cuongcao.
 */
class StoreViewModel(private val storeRepository: StoreRepository) : StoreVMContract {

    override fun getExpressesStore() = storeRepository
            .getStores(StoreAdvanceParam.NEAREST.advanceParam, 1)
}
