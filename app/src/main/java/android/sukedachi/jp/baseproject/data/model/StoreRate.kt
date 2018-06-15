package android.sukedachi.jp.baseproject.data.model

import com.google.gson.annotations.SerializedName

/**
 *
 * @author at-cuongcao.
 */
data class StoreRate(@SerializedName("rate") private var rate: Double,
                     @SerializedName("rate_count") var rateCount: Int) {

    internal fun getRate() = Math.round(rate * 10).toDouble() / 10
}
