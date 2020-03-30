package android.sukedachi.jp.baseproject.api.element

import android.sukedachi.jp.baseproject.BaseTest
import android.sukedachi.jp.baseproject.api.ApiSuiteTest
import android.sukedachi.jp.baseproject.api.ApiSuiteTest.Companion.server
import android.sukedachi.jp.baseproject.data.source.remote.StoreRemoteDataSource
import android.sukedachi.jp.baseproject.data.source.remote.response.StoresResponse
import android.sukedachi.jp.baseproject.extension.addResponseBody
import io.reactivex.observers.TestObserver
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert
import org.junit.Test

/**
 *
 * @author at-vinh.huynh
 */
class StoreRemoteDataSourceTest : BaseTest() {

    @Test
    fun `Given nothing - When call getStores  - Then return correct result`() {
        /* Given */
        val test = TestObserver<StoresResponse>()

        server.addResponseBody("StoreResponse.json")

        /* When */
        StoreRemoteDataSource(ApiSuiteTest.apiClient.service).getStores(1, 1).subscribe(test)

        /* Then */
        test.await().assertValue {
            assertThat(it.nextPageFlag, CoreMatchers.`is`(false))
            assertThat(it.storeList[0].storeId, CoreMatchers.`is`(10L))
            assertThat(it.storeList[0].storeName, CoreMatchers.`is`("Store Name"))
            assertThat(it.storeList[0].storeAddress, CoreMatchers.`is`("Store Address"))
            assertThat(it.storeList[0].storeImage, CoreMatchers.`is`("Store Image"))
            assertThat(it.storeList[0].storeDistance, CoreMatchers.`is`(20182109L))
            true
        }
    }
}
