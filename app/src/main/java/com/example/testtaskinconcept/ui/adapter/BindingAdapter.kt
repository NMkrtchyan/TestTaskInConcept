package com.example.testtaskinconcept.ui.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

class BindingAdapter {
    companion object {
        @BindingAdapter("app:recyclerLayoutManager")
        @JvmStatic
        fun setLayoutManager(view: RecyclerView, manager: RecyclerView.LayoutManager) {
            view.layoutManager = manager
        }
    }
}