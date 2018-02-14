package com.tuonbondol.testedittext

import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.row_layout.view.*

/****
 *
 * Created by TUON BONDOL on 2/14/18.
 *
 */

class DynamicAdapter(var list: ArrayList<String>, val mEnterText: EnterText) : RecyclerView.Adapter<DynamicAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder = ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.row_layout, parent, false))

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind()
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind() {

            itemView.etDynamic.setText(list[adapterPosition])
            itemView.etDynamic.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(stringText: Editable?) {
                    mEnterText.onEditTextCallback(adapterPosition, stringText.toString())
                }

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

            })

            if (adapterPosition == list.size.minus(1)) {
                itemView.etDynamic.requestFocus()
                itemView.etDynamic.isFocusable = true
            }
        }
    }

    interface EnterText {
        fun onEditTextCallback(position: Int, data: String)
    }
}