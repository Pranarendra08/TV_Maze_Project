package com.example.tvmazeproject.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.Html.FROM_HTML_MODE_LEGACY
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.tvmazeproject.ui.adapter.CastAdapter
import com.example.tvmazeproject.api.response.ResponseCastItem
import com.example.tvmazeproject.api.response.ResponseShow
import com.example.tvmazeproject.databinding.ActivityMainBinding
import com.example.tvmazeproject.helper.ViewModelFactory
import com.example.tvmazeproject.ui.castdetail.CastDetailActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mainViewModel by viewModels<MainViewModel> {
        ViewModelFactory.getInstance(application)
    }

    private val showId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val showId = 1
        mainViewModel.detailShow.observe(this@MainActivity) {
            getDetailShow(it)
        }
        mainViewModel.listCast.observe(this@MainActivity) {
            setCast(it)
        }
        mainViewModel.isLoading.observe(this@MainActivity) {
            showLoading(it)
        }
        mainViewModel.getDetailShow(showId)
        mainViewModel.getListCast(showId)

    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

    private fun getDetailShow(itemShow: ResponseShow?) {
        binding.apply {
            tvShowName.text = itemShow?.name
            Glide.with(this@MainActivity)
                .load(itemShow?.image?.medium)
                .apply(RequestOptions.fitCenterTransform())
                .into(imageView)
            tvSchedule.text = "${itemShow?.schedule?.days?.joinToString()} at ${itemShow?.schedule?.time.toString()} (${itemShow?.runtime} min)"
            tvGenre.text = itemShow?.genres!!.joinToString()
            tvRating.text = itemShow.rating.average
            tvShowSummary.text = Html.fromHtml(itemShow.summary, FROM_HTML_MODE_LEGACY)
            tvSeeDetail.setOnClickListener {
                startActivity(
                    Intent(this@MainActivity, CastDetailActivity::class.java)
                        .putExtra(CastDetailActivity.ID, showId)
                )
            }
        }
    }

    private fun setCast(data: List<ResponseCastItem>) {
        val adapter = CastAdapter(data)
        binding.rvPhotos.setHasFixedSize(true)
        binding.rvPhotos.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvPhotos.adapter = adapter
    }
}