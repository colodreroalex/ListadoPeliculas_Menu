package com.example.listas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Info : ActivityWithMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
    }
}