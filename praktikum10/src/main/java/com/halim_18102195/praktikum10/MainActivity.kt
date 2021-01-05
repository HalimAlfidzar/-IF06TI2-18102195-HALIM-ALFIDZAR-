package com.halim_18102195.praktikum10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.halim_18102195.praktikum10.adapter.QuoteAdapter
import com.halim_18102195.praktikum10.databinding.ActivityMainBinding
import com.halim_18102195.praktikum10.db.QuoteHelper

class MainActivity : AppCompatActivity() {
    private lateinit var quoteHelper: QuoteHelper
    private lateinit var adapter: QuoteAdapter
    private val EXTRA_STATE = "EXTRA_STATE"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}