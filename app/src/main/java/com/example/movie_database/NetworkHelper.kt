package com.example.movie_database

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build


fun isNetworkAvailable(context:Context?):Boolean{
            if (context==null)return false
         val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
           if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.Q) {
               val capabilities=cm.getNetworkCapabilities(cm.activeNetwork)
               if( capabilities!=null){
                   when{
                       capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)->{
                           return true
                       }
                       capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)->{
                           return true
                       }
                       capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)->{
                           return true
                       }

                   }


           }else{
               val activenetworkinfo=cm.activeNetworkInfo
               if (activenetworkinfo!=null && activenetworkinfo.isConnected){
                   return false
               }
           }
           }
       return false}



