package com.instagram.data

import android.content.Context
import com.instagram.R

data class News(
    val id: Int,
    val photo: String,
    val name: String,
    val location: String,
    val photos: String,
    val liked: List<String>,
    val time: String
) {

    fun getPhotoID(context: Context): Int = context.resources
        .getIdentifier(photo, "drawable", context.packageName)

    fun getPhotosID(context: Context): Int = context.resources
        .getIdentifier(photos, "drawable", context.packageName)

    fun getLiked(context: Context): String {
        return if (liked.size <= 2) {
            context.resources.getString(
                R.string.in_liked_by, getFirstTwoElementsLiked() )
        } else {
            context.resources.getString(
                R.string.in_liked_by_others, getFirstTwoElementsLiked(), liked.size - 2)
        }
    }

    private fun getFirstTwoElementsLiked(): String {
        return liked.filter { liked.indexOf(it) < 2 }
            .joinToString(separator = ", ") { it }
    }
}