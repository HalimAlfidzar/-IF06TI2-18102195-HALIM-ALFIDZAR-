package com.halim_18102195.praktikum5

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_practice5.*

class Practice5Activity : AppCompatActivity() {

    public val CALL_REQUEST_CODE = 100
    @SuppressLint("MissingPermission")
    private fun setupPermissions() {
        val permission = ContextCompat.checkSelfPermission(this,
            Manifest.permission.CALL_PHONE)

        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.CALL_PHONE),
                CALL_REQUEST_CODE)
        }
    }
    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice5)
        setupPermissions()
        btnProdi.setOnClickListener{
            val namaProdi = inputProdi.text.toString()
            if (namaProdi.isEmpty()) {
                inputProdi.error = getString(R.string.error_input_prodi)
                return@setOnClickListener
            }
            val moveWithDataIntent = Intent(this@Practice5Activity, Practice5ReadDataActivity::class.java)
            moveWithDataIntent.putExtra(Practice5ReadDataActivity.EXTRA_PRODI, namaProdi)
            startActivity(moveWithDataIntent)
        }

        btnCallBrowser.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(getString(R.string.data_url))
            startActivity(intent)
        }

        btnCallCamera.setOnClickListener{
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }

        btnCallPhone.setOnClickListener{
            val phoneNumber = inputPhoneNumber.text.toString()
            if (phoneNumber.isEmpty()) {
                inputPhoneNumber.error = getString(R.string.error_number)
                return@setOnClickListener
            }
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:" + phoneNumber)
            startActivity(intent)
        }

        btnFragment.setOnClickListener{
            val intent = Intent(this, Practice5ForFragmentActivity::class.java)
            startActivity(intent)
        }
    }
}
