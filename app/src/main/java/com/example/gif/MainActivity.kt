package com.example.gif


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gif.databinding.ActivityMainBinding
import kotlinx.coroutines.*



class MainActivity : AppCompatActivity() {
    lateinit var adapter: GifAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var viewModel: ViewModel
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        viewModel= ViewModel()
        viewModel=ViewModelProvider(this).get(ViewModel::class.java)
        viewModel.liveData.observe(this, Observer {
            recyclerView = binding.rec
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = GifAdapter(it)
            recyclerView.adapter = adapter
        }) }
    @DelicateCoroutinesApi
    override fun onStart() {
        super.onStart()
        val button: Button = binding.button2
        button.setOnClickListener {
            val editText = binding.editTextTextPersonName
            val s: String = editText.text.toString()
            GlobalScope.launch(Dispatchers.IO) {
                delay(1000)
                viewModel.search(s)
            }
        }
    }
}