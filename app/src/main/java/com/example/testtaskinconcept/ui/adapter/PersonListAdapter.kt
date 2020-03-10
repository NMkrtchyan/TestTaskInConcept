package com.example.testtaskinconcept.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskinconcept.data.entity.PersonResponse
import com.example.testtaskinconcept.databinding.ListItemBinding


class PersonListAdapter : ListAdapter<PersonResponse, PersonListAdapter.PersonItemViewHolder>(
    PersonListAdapterDiffCallback()
) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PersonItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)

        return PersonItemViewHolder(binding)
    }

    var favoriteClick: ((PersonResponse) -> Unit)? = null


    override fun onBindViewHolder(holder: PersonItemViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.favoriteClick = favoriteClick!!
    }


    class PersonItemViewHolder(
        val binding: ListItemBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        var favoriteClick: ((PersonResponse) -> Unit)? = null

        lateinit var model: PersonResponse

        fun bind(item: PersonResponse) {
            model = item
            binding.model = model
            binding.holder = this

            binding.toggle.setOnCheckedChangeListener{
                buttonView, isChecked ->  model.favorite = isChecked
                favoriteClick?.invoke(model)
            }
        }

    }

    private class PersonListAdapterDiffCallback : DiffUtil.ItemCallback<PersonResponse>() {

        override fun areItemsTheSame(
            oldItem: PersonResponse,
            newItem: PersonResponse
        ): Boolean {
            return !(oldItem === newItem)
        }

        override fun areContentsTheSame(
            oldItem: PersonResponse,
            newItem: PersonResponse
        ): Boolean {
            return oldItem == newItem
        }
    }
}