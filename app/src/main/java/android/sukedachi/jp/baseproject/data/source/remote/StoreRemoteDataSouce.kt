package android.sukedachi.jp.baseproject.data.source.remote

import android.sukedachi.jp.baseproject.data.source.datasource.StoreDataSource
import android.sukedachi.jp.baseproject.data.source.remote.network.ApiClient

class StoreRemoteDataSouce : StoreDataSource {

    private val apiService = ApiClient.getInstance(null).service

    override fun getStores(advanceParam: Int, page: Int) = apiService.getStores(advanceParam, page)
}
