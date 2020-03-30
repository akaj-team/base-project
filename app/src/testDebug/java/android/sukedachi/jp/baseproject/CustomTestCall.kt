package android.sukedachi.jp.baseproject

import android.sukedachi.jp.baseproject.data.source.remote.network.CustomCall
import android.sukedachi.jp.baseproject.data.source.remote.network.CustomCallback
import okhttp3.Request
import retrofit2.Response

/**
 *
 * @author at-tienhoang.
 */
interface CustomTestCall<T> : CustomCall<T> {
    override fun enqueue(callback: CustomCallback<T>) = Unit
    override fun isCanceled() = false
    override fun isExecuted() = true
    override fun cancel() = Unit
    override fun execute() = Response.success<T>(null)
    override fun clone() = this
    override fun request() = Request.Builder().build()
}
