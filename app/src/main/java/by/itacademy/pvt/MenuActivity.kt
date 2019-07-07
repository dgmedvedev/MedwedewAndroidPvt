package by.itacademy.pvt

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button

import by.itacademy.pvt.dz0.Dz0Activity
import by.itacademy.pvt.dz1.Dz1Activity
import by.itacademy.pvt.dz2.Dz2MenuActivity
import by.itacademy.pvt.dz3.Dz3Activity
import by.itacademy.pvt.dz4.Dz4Activity
import by.itacademy.pvt.dz5.Dz5MenuActivity

class MenuActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        findViewById<Button>(R.id.dz0)
            .setOnClickListener {
                startDz0()
            }
        findViewById<Button>(R.id.dz1)
            .setOnClickListener {
                startDz1()
            }
        findViewById<Button>(R.id.dz2)
            .setOnClickListener {
                startDz2()
            }
        findViewById<Button>(R.id.dz3)
            .setOnClickListener {
                startDz3()
            }
        findViewById<Button>(R.id.dz4)
            .setOnClickListener {
                startDz4()
            }
        findViewById<Button>(R.id.dz5)
            .setOnClickListener {
                startDz5()
            }
    }

    private fun startDz0() {
        val intent = Intent(this, Dz0Activity::class.java)
        startActivity(intent)
    }

    private fun startDz1() {
        val intent = Intent(this, Dz1Activity::class.java)
        startActivity(intent)
    }

    private fun startDz2() {
        val intent = Intent(this, Dz2MenuActivity::class.java)
        startActivity(intent)
    }
  
    private fun startDz3() {
        val intent = Intent(this, Dz3Activity::class.java)
        startActivity(intent)
    }

    private fun startDz4() {
        val intent = Intent(this, Dz4Activity::class.java)
        startActivity(intent)
    }
  
    private fun startDz5() {
        val intent = Intent(this, Dz5MenuActivity::class.java)
        startActivity(intent)
    }
}