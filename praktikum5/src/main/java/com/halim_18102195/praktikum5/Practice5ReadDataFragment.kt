package com.halim_18102195.praktikum5

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import com.halim_18102195.praktikum5.Practice5ReadDataFragment.Companion.EXTRA_NAMA
import kotlinx.android.synthetic.main.activity_practice5_read_data.*
import kotlinx.android.synthetic.main.fragment_practice5_read_data.*

class Practice5ReadDataFragment : Fragment() {

    var nim: Int? = null
    companion object {
        var EXTRA_NAMA = ""
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null) {
            val myName = arguments?.getString(EXTRA_NAMA)
            tvMyData.text = getString(R.string.nama_saya) + myName + "\n" + getString(R.string.nim_saya) + nim
        }

        btnKembaliBeranda.setOnClickListener{
            val mIntent = Intent(activity, Practice5Activity::class.java)
            startActivity(mIntent)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_practice5_read_data, container, false)
    }

}
