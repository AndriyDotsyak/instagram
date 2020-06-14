package com.instagram

import com.instagram.screen.home.HomeViewModel
import org.junit.Test

import org.junit.Assert.*

class HomeViewModelUnitTest {

    private val homeViewModel = HomeViewModel()

    @Test
    fun jsonToString_isCorrect() {
        val json = " \"String\" "
        assertEquals("String", homeViewModel.jsonToObject(json, String::class.java))
    }

    @Test
    fun jsonToInt_isCorrect() {
        val json = "7"
        assertEquals(7, homeViewModel.jsonToObject(json, Int::class.java))
    }

    @Test
    fun jsonToArray_isCorrect() {
        val json = " [0, 1, 2, 3, 4] "
        assertEquals(5, homeViewModel.jsonToObject(json, Array<Int>::class.java).size)
    }
}