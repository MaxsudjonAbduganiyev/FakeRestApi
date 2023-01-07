package com.example.posts

import retrofit2.http.GET


    interface NetworkApi {
        @GET("/posts")
        fun getPost():retrofit2.Call<List<Posts>>
    }

