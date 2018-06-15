package android.sukedachi.jp.baseproject.data.model

import com.google.gson.annotations.SerializedName

data class Store(@SerializedName("store_id") val storeId: Long,
                 @SerializedName("store_name") val storeName: String,
                 @SerializedName("store_address") val storeAddress: String,
                 @SerializedName("store_distance") val storeDistance: Long?,
                 @SerializedName("store_rate") var storeRate: StoreRate,
                 @SerializedName("store_image") val storeImage: String)
