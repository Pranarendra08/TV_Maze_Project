package com.example.tvmazeproject.ui.castdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tvmazeproject.ui.main.MainViewModel
import com.example.tvmazeproject.api.response.ResponseCastItem
import com.example.tvmazeproject.databinding.ActivityCastDetailBinding
import com.example.tvmazeproject.helper.ViewModelFactory
import com.example.tvmazeproject.ui.adapter.CastDetailAdapter

class CastDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCastDetailBinding

    private val mainViewModel by viewModels<MainViewModel> {
        ViewModelFactory.getInstance(application)
    }

    companion object {
        const val ID = "id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCastDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.extras?.get(ID) as Int
        mainViewModel.listCast.observe(this@CastDetailActivity) {
            setCast(it)
        }
        mainViewModel.isLoading.observe(this@CastDetailActivity) {
            showLoading(it)
        }
        mainViewModel.getListCast(id)
    }

    private fun setCast(data: List<ResponseCastItem>) {
        val adapter = CastDetailAdapter(data)
        binding.rvDetailCast.setHasFixedSize(true)
        binding.rvDetailCast.layoutManager = LinearLayoutManager(this)
        binding.rvDetailCast.adapter = adapter
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }
}