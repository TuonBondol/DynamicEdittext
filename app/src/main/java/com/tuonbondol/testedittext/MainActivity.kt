package com.tuonbondol.testedittext

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), DynamicAdapter.EnterText {

    private var mDynamicAdapter: DynamicAdapter? = null
    private var mList = arrayListOf("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rlDynamicEditText.layoutManager = LinearLayoutManager(this)
        mDynamicAdapter = DynamicAdapter(mList, this)
        rlDynamicEditText.adapter = mDynamicAdapter

        fabAddNew.setOnClickListener {
            mList.add("")
            mDynamicAdapter?.notifyDataSetChanged()
        }

        fabSave.setOnClickListener {
            val dataList: ArrayList<String> = ArrayList()
            mList.filterNotTo(dataList) { it.isEmpty() }
        }
    }

    override fun onEditTextCallback(position: Int, data: String) {
        mList[position] = data
    }
}
