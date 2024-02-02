package com.example.movie_database

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener

import androidx.appcompat.app.AppCompatActivity
import com.example.movie_database.databinding.ActivityAnimationBinding
import com.example.movie_database.databinding.ActivityDataBinding

abstract class MainActivity:AppCompatActivity() {


     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)









     }

   abstract fun isAnimationActivity():Boolean
    abstract fun isDataActivity():Boolean

}