package com.dicoding.myrecyclerview

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MoveActivity: AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_move)

        val btnMoveActivity: Button = findViewById(R.id.button_back_to_menu)
        btnMoveActivity.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        // ketika di click akan berpindah ke activity lain
        when (v?.id) {
            R.id.button_back_to_menu -> {
                // Ketika menekan tombol move maka ia akan beralih ke MoveActivity
                val moveIntent = Intent(this@MoveActivity, MainActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }
}