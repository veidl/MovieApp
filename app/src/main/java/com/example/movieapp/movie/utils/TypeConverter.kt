package com.example.movieapp.movie.utils

import androidx.room.TypeConverter

class TypeConverter {

    @TypeConverter
    fun fromArrayList(list: MutableList<String>): String {
        return list.joinToString { "," }
    }

    @TypeConverter
    fun toArrayList(string: String): MutableList<String> {
        return string.split(",").toMutableList()
    }
}