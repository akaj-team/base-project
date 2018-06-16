package android.sukedachi.jp.baseproject.ui.main

import android.os.Bundle
import android.sukedachi.jp.baseproject.data.model.Store
import android.sukedachi.jp.baseproject.data.source.StoreRepository
import android.sukedachi.jp.baseproject.data.source.remote.response.StoresResponse
import android.sukedachi.jp.baseproject.extension.observeOnUiThread
import android.sukedachi.jp.baseproject.ui.base.BaseFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.AnkoContext

/**
 *
 * @author at-cuongcao.
 */
class StoreFragment : BaseFragment() {

    private lateinit var viewModel: StoreVMContract
    private lateinit var ui: StoreFragmentUI
    private val stores = mutableListOf<Store>()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = StoreViewModel(StoreRepository())
        ui = StoreFragmentUI(stores)
        return ui.createView(AnkoContext.create(context, this))
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getExpressesStore()
                .observeOnUiThread()
                .subscribe(this::handleGetStoreListSuccess, this::handleGetStoreListError)
    }

    override fun onBindViewModel() = Unit

    private fun handleGetStoreListSuccess(storesResponse: StoresResponse) {
        stores.clear()
        stores.addAll(storesResponse.storeList)
        ui.storeAdapter.notifyDataSetChanged()
    }

    private fun handleGetStoreListError(throwable: Throwable) {
        // Handle Error here.
    }
}
