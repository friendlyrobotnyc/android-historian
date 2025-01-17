package com.designdemo.uaha.view.product.os

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import com.bumptech.glide.Glide
import com.designdemo.uaha.view.detail.DetailActivity
import com.support.android.designlibdemo.R

import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.designdemo.uaha.data.model.product.ProductEntity
import kotlinx.android.synthetic.main.list_item_os.view.*

class OsTypeAdapter(private val activity: Activity, context: Context, private val values: List<ProductEntity>) :
        RecyclerView.Adapter<OsTypeAdapter.ViewHolder>() {

    private val typedValue = TypedValue()
    private val background: Int

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        var boundString: String? = null
        val imageView: ImageView = view.os_item_avatar
        val titleText = view.os_item_title
        val subTitleText = view.os_item_subtext
        var osVersion: Int = 0

        override fun toString() = super.toString() + " '" + titleText.text
    }

    fun getValueAt(position: Int) = values[position]

    init {
        context.theme.resolveAttribute(R.attr.selectableItemBackground, typedValue, true)
        background = typedValue.resourceId
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_os, parent, false)

        view.setBackgroundResource(background)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.boundString = values[position].title
        holder.titleText.text = values[position].title
        holder.subTitleText.text = values[position].subTitle

        holder.view.setOnClickListener { v ->
            val context = v.context
            val intent = Intent(context, DetailActivity::class.java)
            val intentString = "${values[position].title}-${values[position].subTitle}"
            intent.putExtra(DetailActivity.EXTRA_APP_NAME, intentString)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val transitionName = context.getString(R.string.transition_string)
                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        activity,
                        holder.imageView,
                        transitionName)
                context.startActivity(intent, options.toBundle())
            } else {
                context.startActivity(intent)
            }
        }

        Glide.with(holder.imageView.context)
                .load(values[position].imgId)
                .fitCenter()
                .into(holder.imageView)
    }

    override fun getItemCount() = values.size
}
