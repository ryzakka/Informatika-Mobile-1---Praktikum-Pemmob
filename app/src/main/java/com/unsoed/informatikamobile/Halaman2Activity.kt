package com.unsoed.informatikamobile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import android.content.Intent
import com.unsoed.informatikamobile.databinding.ActivityHalaman2Binding

class Halaman2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityHalaman2Binding
    private val latitude: String = "-7.429427"
    private val longitude: String = "109.338082"
    private val gMapsUrl: String = "https://maps.google.com/maps?q=loc:"
    private val packageMaps: String = "com.google.android.apps.maps"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHalaman2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initLayout()
        initListener()
    }

    private fun initLayout() {
        binding.layoutLocation.let {
            it.imgIcon.setImageResource(R.drawable.ic_location)
            it.tvLayout.setText(R.string.alamat)
        }

        binding.layoutEmail.let {
            it.imgIcon.setImageResource(R.drawable.ic_email)
            it.tvLayout.setText(R.string.email)
        }

        binding.layoutIg.let {
            it.imgIcon.setImageResource(R.drawable.ic_himpunan)
            it.tvLayout.setText(R.string.ig_himpunan)
        }

        binding.layoutPhone.let {
            it.imgIcon.setImageResource(R.drawable.ic_phone)
            it.tvLayout.setText(R.string.telepon)
        }
    }

    private fun initListener() {
        binding.layoutLocation.root.setOnClickListener {
            val gMapsIntentUri = "$gMapsUrl$latitude,$longitude".toUri()

            val mapIntent = Intent(Intent.ACTION_VIEW, gMapsIntentUri)
            mapIntent.setPackage(packageMaps)
            startActivity(mapIntent)
        }
        binding.layoutIg.root.setOnClickListener {
            val instagramUri = getString(R.string.ig_himpunan).toUri()

            val intent = Intent(Intent.ACTION_VIEW, instagramUri)
            startActivity(intent)
        }
        binding.layoutEmail.root.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = "mailto:${getString(R.string.email)}".toUri()
            }
            startActivity(intent)
        }

        binding.layoutPhone.root.setOnClickListener {
            val intent = Intent().apply {
                action = Intent.ACTION_DIAL
                data = "tel:${getString(R.string.telepon)}".toUri()
            }
            startActivity(intent)
        }
        binding.btnBack.setOnClickListener{
            finish()
        }
    }
}
