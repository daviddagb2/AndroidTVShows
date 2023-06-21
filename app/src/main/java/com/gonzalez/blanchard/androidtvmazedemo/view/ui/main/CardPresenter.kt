package com.gonzalez.blanchard.androidtvmazedemo.view.ui.main

import android.view.ViewGroup
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter
import com.gonzalez.blanchard.androidtvmazedemo.domain.models.TvShowItem
import com.gonzalez.blanchard.androidtvmazedemo.view.ui.common.loadUrl

class CardPresenter: Presenter() {
    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val cardView = ImageCardView(parent.context).apply {
            isFocusable = true
            isFocusableInTouchMode = true
            setMainImageDimensions(210, 295)
        }
        return ViewHolder(cardView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any) {
        val tvserie = item as TvShowItem
        with(viewHolder.view as ImageCardView) {
            titleText = tvserie.name
            contentText = tvserie.premiered
            mainImageView.loadUrl(tvserie.image.medium)
        }

    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder) {
        with(viewHolder.view as ImageCardView) {
            mainImage = null
        }
    }

}