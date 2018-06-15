package android.sukedachi.jp.baseproject.data.source.remote.response

import android.sukedachi.jp.baseproject.data.model.Store
import com.google.gson.annotations.SerializedName

/**
 *
 * @author at-cuongcao.
 */
data class StoresResponse(@SerializedName("next_page_flag") var nextPageFlag: Boolean,
                          @SerializedName("store_list") var storeList: MutableList<Store>)
