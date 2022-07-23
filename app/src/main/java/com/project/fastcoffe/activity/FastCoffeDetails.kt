package com.project.fastcoffe.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.project.fastcoffe.R

class FastCoffeDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fastcoffe_details_activity)

        val actionbar = supportActionBar
        actionbar!!.title = "Details"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val imgSetPhoto: ImageView = findViewById(R.id.imgCoffe_CoffeDetails)
        val tvSetIden: TextView = findViewById(R.id.textCoffe_CoffeDetails)

        val tImg = intent.getStringExtra(EXTRA_IMAGE)
        val tIDetail = intent.getStringExtra(EXTRA_DETAIL)


        Glide.with(this)
            .load(tImg)
            .apply(RequestOptions())
            .into(imgSetPhoto)
        tvSetIden.text = tIDetail
    }

    companion object {
        const val EXTRA_IMAGE = "extra_image"
        const val EXTRA_DETAIL = "extra_detail"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
