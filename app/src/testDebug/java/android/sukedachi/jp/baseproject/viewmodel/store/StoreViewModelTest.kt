package android.sukedachi.jp.baseproject.viewmodel.store

import android.sukedachi.jp.baseproject.BaseTest
import android.sukedachi.jp.baseproject.data.model.Store
import android.sukedachi.jp.baseproject.data.model.StoreRate
import android.sukedachi.jp.baseproject.data.source.StoreRepository
import android.sukedachi.jp.baseproject.data.source.remote.response.StoresResponse
import android.sukedachi.jp.baseproject.ui.main.StoreViewModel
import android.sukedachi.jp.baseproject.util.RxSchedulersOverrideRule
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 *
 * @author at-vinh.huynh
 */
@Suppress("IllegalIdentifier")
class StoreViewModelTest : BaseTest() {

    @get:Rule
    val rule = RxSchedulersOverrideRule()

    @Mock
    private lateinit var storeRepository: StoreRepository

    private lateinit var viewModel: StoreViewModel

    @Before
    fun beforeTest() {
        MockitoAnnotations.initMocks(this)
        viewModel = StoreViewModel(storeRepository)
    }

    @Test
    fun `Given Nothing - When call constructor StoreViewModel - Then has no exception`() {
        /* Given */

        /* When */

        /* Then */
        Assert.assertThat(viewModel, CoreMatchers.notNullValue())
    }

    @Test
    fun `Given nothing - When call getExpressesStore - Then return correct result`() {
        /* Given */
        val testObserver = TestObserver<StoresResponse>()

        val storeRate = StoreRate(1.1, 1)
        val store = Store(2L, "storeName", "storeAddress", 2L, storeRate, "storeImage")
        val storeList = mutableListOf<Store>()
        storeList.add(store)

        val storeResponse = StoresResponse(false, storeList)
        /* When */
        Mockito.`when`(storeRepository.getStores(1, 1)).thenReturn(Single.just(storeResponse))
        viewModel.getExpressesStore().subscribe(testObserver)

        /* Then */
        testObserver.assertValue {
            assertThat(it.nextPageFlag, CoreMatchers.`is`(false))
            assertThat(it.storeList.size, CoreMatchers.`is`(1))
            true
        }
    }
}
