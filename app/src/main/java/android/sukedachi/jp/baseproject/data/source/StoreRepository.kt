package android.sukedachi.jp.baseproject.data.source

import android.sukedachi.jp.baseproject.data.source.datasource.StoreDataSource
import android.sukedachi.jp.baseproject.data.source.remote.StoreRemoteDataSource

class StoreRepository : StoreDataSource {

    private val storeRemoteDataSouce = StoreRemoteDataSource()

    override fun getStores(advanceParam: Int, page: Int) = storeRemoteDataSouce.getStores(advanceParam, page)
}
