package com.example.booking_room

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var isActiveMenu : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val user = FirebaseAuth.getInstance().currentUser
        nameUser.text = user?.displayName
        myDatPhong.setOnClickListener {
            val intent : Intent = Intent(this@MainActivity, DatPhong::class.java)
            startActivity(intent)
        }
        btnMenu.setOnClickListener {
            if(isActiveMenu) {
                content.animate().translationX(-800.toFloat())
                menu.animate().translationX(-1000.toFloat())
                btnMenu.setImageResource(R.drawable.ic_dehaze_white_24dp)
            } else {
                content.animate().translationX(0.toFloat())
                menu.animate().translationX(0.toFloat())
                btnMenu.setImageResource(R.drawable.ic_baseline_vertical_split_24)
            }
            isActiveMenu = !isActiveMenu
        }
    }
}
