package com.dicoding.myrecyclerview


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 2000 // Waktu tampil splash screen (dalam milidetik)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // Tambahkan pesan log untuk menandai awal onCreate
        Log.d("SplashScreenActivity", "onCreate: Splash screen dimulai")
        println("Haloooo")
        Handler().postDelayed({
            // Tambahkan pesan log untuk menandai sebelum berpindah ke activity utama
            Log.d("SplashScreenActivity", "Pindah ke MainActivity")

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIME_OUT)
    }
}

