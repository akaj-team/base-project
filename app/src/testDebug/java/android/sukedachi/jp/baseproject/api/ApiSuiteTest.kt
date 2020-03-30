package android.sukedachi.jp.baseproject.api

import android.sukedachi.jp.baseproject.api.element.StoreRemoteDataSourceTest
import android.sukedachi.jp.baseproject.data.source.remote.network.ApiClient
import okhttp3.HttpUrl
import okhttp3.mockwebserver.MockWebServer
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.runner.RunWith
import org.junit.runners.Suite

/**

 * @author at-vinhhuynh.
 */
@RunWith(Suite::class)
@Suite.SuiteClasses(
        StoreRemoteDataSourceTest::class
)
class ApiSuiteTest {

    companion object {
        internal val server = MockWebServer()
        internal lateinit var baseUrl: HttpUrl

        @BeforeClass
        @JvmStatic
        fun beforeClass() {
            ApiClient.clearInstance()
            try {
                server.start()
            } catch (e: IllegalStateException) {
                println(e.message)
            }
            baseUrl = server.url("/")
        }

        @AfterClass
        @JvmStatic
        fun afterClass() {
            server.shutdown()
            ApiClient.clearInstance()
        }

        internal val apiClient: ApiClient
            get() = ApiClient.getInstance(baseUrl.toString(), true)
    }
}
