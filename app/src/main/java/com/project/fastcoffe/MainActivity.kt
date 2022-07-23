package com.project.fastcoffe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.fastcoffe.activity.AboutMe
import com.project.fastcoffe.adapter.FastCoffeAdapter
import com.project.fastcoffe.data.AllData
import com.project.fastcoffe.data.CoffeDetailsData

class MainActivity : AppCompatActivity() {
    private lateinit var rvCoffes: RecyclerView
    private var list: ArrayList<AllData> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar = supportActionBar
        actionBar!!.title = "Fast Coffe"

        rvCoffes = findViewById(R.id.rv_recycleviewlist)
        rvCoffes.setHasFixedSize(true)

       list.addAll(CoffeDetailsData.listData)
       showRecyclerList()


    }

    private fun showRecyclerList() {
        rvCoffes.layoutManager = LinearLayoutManager(this)
        val fastCoffeAdapter = FastCoffeAdapter(list)
        rvCoffes.adapter = fastCoffeAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.about_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.about_MenuMainActivity -> startActivity(
                Intent(this, AboutMe::class.java)
            )
        }

        return true
    }
}
