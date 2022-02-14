package com.example.gunungindonesia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlin.jvm.internal.MagicApiIntrinsics

class MountainDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mountain_details)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        dataBinding()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun dataBinding() {
        val heading: TextView = findViewById(R.id.tv_mountain_name)
        val image: ImageView = findViewById(R.id.iv_mountain)
        val details: TextView = findViewById(R.id.tv_mountain_detail)
        val height: TextView = findViewById(R.id.tv_height)
        val location: TextView = findViewById(R.id.tv_location)

        val bundle: Bundle? = intent.extras
        val title = bundle?.getString(MainActivity.HEADING)
        val mountainImage = bundle?.getInt(MainActivity.IMAGE_ID)
        val mountainDetails = bundle?.getString(MainActivity.DETAILS)
        val mountainHeight = bundle?.getString(MainActivity.HEIGHT)
        val mountainLocation = bundle?.getString(MainActivity.LOCATION)

        heading.text = title
        image.setImageResource(mountainImage ?: 0)
        details.text = mountainDetails
        height.text = mountainHeight
        location.text = mountainLocation
    }
}