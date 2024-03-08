package com.dicoding.myrecyclerview

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        // ketika di click akan berpindah ke activity lain
        when (v?.id) {
            R.id.action_back -> {
                // Ketika menekan tombol move maka ia akan beralih ke MoveActivity
                val moveIntent = Intent(this@DetailActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.action_share -> {
                shareButtonClick()
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_hero, menu)
        return true
    }

    private fun shareButtonClick() {
        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = "text/plain"
        val shareBody = "Isi pesan yang ingin Anda bagikan"
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
        startActivity(Intent.createChooser(sharingIntent, "Bagikan menggunakan"))
    }
    fun shareButtonClick(view: View) {
        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = "text/plain"
        val shareBody = "Isi pesan yang ingin Anda bagikan"
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
        startActivity(Intent.createChooser(sharingIntent, "Bagikan menggunakan"))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_back -> {
                val moveIntent = Intent(this@DetailActivity, MainActivity::class.java)
                startActivity(moveIntent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataHero = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Hero>("key_hero")
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Hero>("key_hero")
        }

        val imageViewHeroPhoto: ImageView = findViewById(R.id.imageViewHeroPhoto)
        val tvHeroName: TextView = findViewById(R.id.tvHeroName)
        val tvHeroSpecies: TextView = findViewById(R.id.tvHeroSpecies)
        val tvHeroDescription: TextView = findViewById(R.id.tvHeroDescription)
        val tvHeroStory: TextView = findViewById(R.id.tvHeroStory)
        val tvHeroHeight: TextView = findViewById(R.id.tvHeroHeight)
        val tvHeroWeight: TextView = findViewById(R.id.tvHeroWeight)
        val tvHeroAbilities: TextView = findViewById(R.id.tvHeroAbilities)
        val tvHeroWeapons: TextView = findViewById(R.id.tvHeroWeapons)
        val tvHeroRelation: TextView = findViewById(R.id.tvHeroRelation)
        val tvHeroLongStory: TextView = findViewById(R.id.tvHeroLongStory)
        val buttonAction: Button = findViewById(R.id.action_share)


        // Tentukan foto berdasarkan nama pahlawan
        val photoResId = when (dataHero?.name) {
            "Cecilion" -> R.drawable.cecilion_1
            "Carmilla" -> R.drawable.carmila_2
            "Jhonson" -> R.drawable.jhonson_3
            "Fanny" -> R.drawable.fanny_4
            "Ling" -> R.drawable.ling_5
            "Yuzhong" -> R.drawable.yuzhong_6
            "Esmeralda" -> R.drawable.esmeralda_7
            "Guinevere" -> R.drawable.guinevere_8
            "Lunox" -> R.drawable.lunox_9
            "Kagura" -> R.drawable.kagura_10
            else -> R.drawable.photoprofile
        }
        imageViewHeroPhoto.setImageResource(photoResId)

        tvHeroName.text = dataHero?.fullname
        tvHeroSpecies.text = dataHero?.species
        tvHeroDescription.text = dataHero?.description
        tvHeroStory.text = dataHero?.story
        tvHeroHeight.text = dataHero?.height
        tvHeroWeight.text = dataHero?.weight
        tvHeroAbilities.text = dataHero?.abilities
        tvHeroWeapons.text = dataHero?.weapons
        tvHeroRelation.text = dataHero?.relation
        tvHeroLongStory.text = dataHero?.longstory
        buttonAction.setOnClickListener(this)
    }
}

