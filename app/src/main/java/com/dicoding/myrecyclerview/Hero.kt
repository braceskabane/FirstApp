package com.dicoding.myrecyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero(
    val name: String,
    val description: String,
    val story: String,
    val photo: Int,
    val fullname: String,
    val species: String,
    val weapons: String,
    val abilities: String,
    val height: String,
    val weight: String,
    val relation: String,
    val longstory: String,
    val quotes: String
) : Parcelable
