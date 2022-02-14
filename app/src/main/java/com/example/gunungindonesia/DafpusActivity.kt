package com.example.gunungindonesia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DafpusActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dafpus)
        supportActionBar?.title = getString(R.string.text_dafpus_activity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}