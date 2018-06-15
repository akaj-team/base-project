package android.sukedachi.jp.baseproject.ui.main

import android.sukedachi.jp.baseproject.BuildConfig
import android.sukedachi.jp.baseproject.R
import android.sukedachi.jp.baseproject.data.model.Store
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.textResource

/**
 *
 * @author at-cuongcao.
 */
class StoreAdapter(private val storeInfoExpresses: MutableList<Store>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    internal var onItemClicked: (item: Store) -> Unit = {}

    override fun getItemCount() = storeInfoExpresses.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val ui = StoreItemUI()
        return StoreHolder(ui, ui.createView(AnkoContext.Companion.create(parent.context, parent)))

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? StoreHolder)?.onBind()
    }

    inner class StoreHolder(val ui: StoreItemUI, itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val option = RequestOptions()
                .placeholder(R.drawable.glide_place_holder)

        init {
            itemView.onClick {
                onItemClicked(storeInfoExpresses[adapterPosition])
            }
        }

        internal fun onBind() {
            with(storeInfoExpresses[adapterPosition]) {
                Glide.with(itemView.context)
                        .applyDefaultRequestOptions(option)
                        .asBitmap()
                        .load(BuildConfig.BASE_IMAGE_URL + storeImage)
                        .into(ui.imgStoreIcon)
                ui.tvStoreName.text = storeName
                ui.tvStoreAddress.text = storeAddress
                if (storeRate.rateCount == 0) {
                    ui.tvStoreStarRate.textResource = R.string.not_rate_yet
                } else {
                    ui.tvStoreStarRate.text = itemView.context.getString(R.string.store_rate, storeRate.getRate().toString(), storeRate.rateCount.toString())
                }
            }
        }
    }
}
