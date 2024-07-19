package com.example.exam.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exam.adapter.MovieAdapter
import com.example.exam.MovieViewModel
import com.example.exam.databinding.ActivityMainBinding
import com.example.movieapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MovieViewModel by viewModels()
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movieAdapter = MovieAdapter { movie ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("movie", movie.id)
            startActivity(intent)
        }

        binding.moviesRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = movieAdapter
        }

        binding.searchButton.setOnClickListener {
            val query = binding.searchEditText.text.toString()
            viewModel.searchMovies(query).observe(this) { movies ->
                movieAdapter.submitList(movies)
            }
        }
    }
}


/*import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {


        private lateinit var binding: ActivityMainBinding
        private lateinit var adapter: TaskAdapter




        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)


            taskDAO = TaskDAO(this)



            adapter = TaskAdapter(emptyList(), {
                Toast.makeText(this, "Click: ${taskList[it].name}", Toast.LENGTH_SHORT).show()
            }, {
                val task = taskList[it]
                taskDAO.delete(task)
                Toast.makeText(this, "TTTT", Toast.LENGTH_SHORT).show()
                loadData()


            }, {
                val task = taskList[it]
                task.done = !task.done
                taskDAO.update(task)
                loadData()
            })



            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = LinearLayoutManager(this)

            binding.addTaskButton.setOnClickListener {
                val intent = Intent(this, TaskActivity::class.java)
                startActivity(intent)
            }
        }



        override fun onResume() {
            super.onResume()

            loadData()
        }

        private fun loadData() {
            taskList = taskDAO.findAll()

            adapter.updateData(taskList)
        }


    }

*/