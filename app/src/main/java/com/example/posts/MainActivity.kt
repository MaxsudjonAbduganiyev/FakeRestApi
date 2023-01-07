package com.example.posts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.posts.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var recAdapter: RecAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recAdapter= RecAdapter()
        binding.recycylerview.adapter=recAdapter


        val retrofit=RetrofitHelper.getRetrofit()
        val call = retrofit.create(NetworkApi::class.java)



        call.getPost().enqueue(object : Callback<List<Posts>> {
            override fun onResponse(
                call: Call<List<Posts>>,
                response: Response<List<Posts>>
            ) {
                recAdapter.submitList(response.body())
            }

            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }
}