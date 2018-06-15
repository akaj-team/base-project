package android.sukedachi.jp.baseproject.ui.main

import android.sukedachi.jp.baseproject.data.source.StoreRepository
import android.sukedachi.jp.baseproject.ui.main.StoreFragmentAdvanceParam

/**
 *
 * @author at-cuongcao.
 */
class StoreFragmentViewModel(private val storeRepository: StoreRepository) {

    internal fun getExpressesStore() = storeRepository.getStores(StoreFragmentAdvanceParam.NEAREST.advanceParam, 1)
}
