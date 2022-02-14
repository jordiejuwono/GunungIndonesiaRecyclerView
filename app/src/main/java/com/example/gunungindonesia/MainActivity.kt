package com.example.gunungindonesia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object {
        const val HEADING = "heading"
        const val IMAGE_ID = "image_id"
        const val DETAILS = "details"
        const val HEIGHT = "height"
        const val LOCATION = "location"
    }

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Mountains>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>
    lateinit var details: Array<String>
    lateinit var height: Array<String>
    lateinit var location: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = getString(R.string.title_homepage)

        getMountainData()
        viewRecyclerList()
    }

    private fun getMountainData() {
        imageId = MountainData.mountainPhotos
        heading = MountainData.mountainName
        details = MountainData.mountainDetails
        height = MountainData.mountainHeight
        location = MountainData.mountainLocation
    }

    private fun viewRecyclerList() {
        newRecyclerView = findViewById(R.id.rv_mountains)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Mountains>()
        getIntentData()
    }

    private fun getIntentData() {
        for (i in imageId.indices) {
            val mountain = Mountains(imageId[i], heading[i], details[i])
            newArrayList.add(mountain)
        }

        var adapter = MyAdapter(newArrayList)

        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(this@MainActivity, MountainDetailsActivity::class.java)
                intent.putExtra(HEADING, newArrayList[position].heading)
                intent.putExtra(IMAGE_ID, newArrayList[position].titleImage)
                intent.putExtra(DETAILS, newArrayList[position].details)
                intent.putExtra(HEIGHT, height[position])
                intent.putExtra(LOCATION, location[position])
                startActivity(intent)

            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        openMenu(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun openMenu(selectedMenu: Int) {
        when(selectedMenu){
            R.id.action_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
            }
            R.id.action_dafpus -> {
                val intent = Intent(this, DafpusActivity::class.java)
                startActivity(intent)
            }
        }
    }

}