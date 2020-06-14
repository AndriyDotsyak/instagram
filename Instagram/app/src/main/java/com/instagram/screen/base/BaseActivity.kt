package com.instagram.screen.base

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.instagram.di.Injectable
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity(), Injectable {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    fun showToast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}