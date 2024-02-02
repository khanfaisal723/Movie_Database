package com.example.movie_database


import android.content.Intent

import android.os.Bundle
import android.view.View
import retrofit2.Callback
import com.example.movie_database.databinding.ActivityDataBinding
import retrofit2.Call
import retrofit2.Response

class DataActivity : MainActivity() {
    private lateinit var binding: ActivityDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)
        binding = ActivityDataBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.refresh.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {

                if (isDataActivity() && isNetworkAvailable(applicationContext) == false) {

                    intent = Intent(applicationContext, AnimationActivity::class.java)
                    startActivity(intent)

                }


                val retrofitHelper = RetrofitHelper.retrofit.create(RetrofitHelper::class.java)
                val call = retrofitHelper.getData()

                call.enqueue(object : Callback<List<Data>> {
                    override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>) {
                      binding.data.text= response.body()?.get(0)?.title
                    }

                    override fun onFailure(call: Call<List<Data>>, t: Throwable) {

                    }

                })


            }

        })


    }

    override fun isAnimationActivity() = false
    override fun isDataActivity() = true

}