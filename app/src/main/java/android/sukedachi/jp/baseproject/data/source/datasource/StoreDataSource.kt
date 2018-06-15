package android.sukedachi.jp.baseproject.data.source.datasource

import android.sukedachi.jp.baseproject.data.source.remote.response.StoresResponse
import io.reactivex.Single

interface StoreDataSource {

    fun getStores(advanceParam: Int, page: Int): Single<StoresResponse>
}