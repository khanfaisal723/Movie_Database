package com.example.movie_database

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.movie_database.databinding.ActivityAnimationBinding
import com.example.movie_database.databinding.ActivityDataBinding

class AnimationActivity : MainActivity() {
    private lateinit var binding:ActivityAnimationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding =ActivityAnimationBinding.inflate(layoutInflater)
     setContentView(binding.root)

        binding.refresh.setOnClickListener(object : View.OnClickListener{

            override fun onClick(v: View?) {

                if (isAnimationActivity() && isNetworkAvailable(applicationContext)){
                    intent= Intent(applicationContext,DataActivity::class.java)
                    startActivity(intent)

                }
            }
        })


    }


    override fun isAnimationActivity()=true
    override  fun isDataActivity()=false
}