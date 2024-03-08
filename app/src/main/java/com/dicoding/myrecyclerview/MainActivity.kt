package com.dicoding.myrecyclerview

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity: AppCompatActivity() {
    private lateinit var rvHeroes: RecyclerView
    private val list = ArrayList<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHeroes = findViewById(R.id.rv_heroes)
        rvHeroes.setHasFixedSize(true)

        list.addAll(getListHeroes())
        showRecyclerList()

        val dataHero = intent.getParcelableExtra<Hero>("key_hero")
    }


    private fun getListHeroes(): ArrayList<Hero> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataStory = resources.getStringArray(R.array.data_story)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataLongStory = resources.getStringArray(R.array.data_longstory)
        val dataRelationship = resources.getStringArray(R.array.data_relationship)
        val dataWeight = resources.getStringArray(R.array.data_weight)
        val dataHeight = resources.getStringArray(R.array.data_height)
        val dataAbilities = resources.getStringArray(R.array.data_abilities)
        val dataWeapons = resources.getStringArray(R.array.data_weapons)
        val dataSpecies = resources.getStringArray(R.array.data_species)
        val dataFullname = resources.getStringArray(R.array.data_fullname)
        val dataQuotes = resources.getStringArray(R.array.data_quotes)

        val listHero = ArrayList<Hero>()
        for (i in dataName.indices) {
            val hero = Hero(
                dataName[i],
                dataDescription[i],
                dataStory[i],
                dataPhoto.getResourceId(i, -1),
                longstory = dataLongStory[i],
                relation = dataRelationship[i],
                weight = dataWeight[i],
                height = dataHeight[i],
                abilities = dataAbilities[i],
                weapons = dataWeapons[i],
                species = dataSpecies[i],
                fullname = dataFullname[i],
                quotes = dataQuotes[i]
            )
            listHero.add(hero)
        }
        return listHero
    }

    private fun showRecyclerList() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rvHeroes.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : ListHeroAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Hero) {
                showSelectedHero(data)
            }
        })
    }

    private fun showSelectedHero(hero: Hero) {
        Toast.makeText(this, "Kamu memilih " + hero.name, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvHeroes.layoutManager = LinearLayoutManager(this)
            }

            R.id.action_grid -> {
                rvHeroes.layoutManager = GridLayoutManager(this, 2)
            }
            R.id.action_about -> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}