package android.sukedachi.jp.baseproject.data.source.remote.network

import android.sukedachi.jp.baseproject.data.source.remote.response.StoresResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *
 * @author at-cuongcao.
 */
interface ApiService {

    @GET("api/v1/store/express.php")
    fun getStores(@Query("advance_param") advanceParam: Int, @Query("page") page: Int): Single<StoresResponse>
}
