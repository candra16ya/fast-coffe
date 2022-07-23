package com.project.fastcoffe.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.project.fastcoffe.R

class AboutMe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_me_activity)
        val actionbar = supportActionBar
        actionbar!!.title = "About Me"
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(selectedItem: MenuItem): Boolean {
        when(selectedItem.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(selectedItem)
    }

}