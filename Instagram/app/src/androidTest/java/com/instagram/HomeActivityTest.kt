package com.instagram

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.instagram.screen.home.HomeActivity

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class HomeActivityTest {

    @Test
    fun getNewsJSON() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val newsJSON = appContext.resources.openRawResource(R.raw.news).bufferedReader().use { it.readText() }
        assertNotNull(newsJSON)
    }
}