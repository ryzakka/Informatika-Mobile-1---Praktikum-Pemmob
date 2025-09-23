// File: MainActivity.kt

package com.unsoed.informatikamobile

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.unsoed.informatikamobile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        initNavigation()
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets -> // Menggunakan binding.main
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun initNavigation() {
        binding.btnToPage2.setOnClickListener {
            val intent = Intent(this, Halaman2Activity::class.java)
            startActivity(intent)
        }
    }
}