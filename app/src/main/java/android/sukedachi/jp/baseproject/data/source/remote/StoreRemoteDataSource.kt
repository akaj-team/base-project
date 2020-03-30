package android.sukedachi.jp.baseproject.data.source.remote

import android.sukedachi.jp.baseproject.data.source.datasource.StoreDataSource
import android.sukedachi.jp.baseproject.data.source.remote.network.ApiClient
import android.sukedachi.jp.baseproject.data.source.remote.network.ApiService

class StoreRemoteDataSource(private val api: ApiService) : StoreDataSource {

    constructor() : this(ApiClient.getInstance(null).service)

    override fun getStores(advanceParam: Int, page: Int) = api.getStores(advanceParam, page)
}
