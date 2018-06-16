package android.sukedachi.jp.baseproject.ui.main

import android.sukedachi.jp.baseproject.data.source.remote.response.StoresResponse
import io.reactivex.Single

interface StoreVMContract {

    fun getExpressesStore(): Single<StoresResponse>
}
