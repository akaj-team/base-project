package android.sukedachi.jp.baseproject.data.source

import android.sukedachi.jp.baseproject.data.source.datasource.StoreDataSource
import android.sukedachi.jp.baseproject.data.source.remote.StoreRemoteDataSouce

class StoreRepository : StoreDataSource {

    private val storeRemoteDataSouce = StoreRemoteDataSouce()

    override fun getStores(advanceParam: Int, page: Int) = storeRemoteDataSouce.getStores(advanceParam, page)
}
