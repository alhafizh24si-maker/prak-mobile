package com.example.hafizh_cool

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class kalkulator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_kalkulator)

        // Mengatur padding agar UI tidak tertutup Status Bar/Navigasi (Edge-to-Edge)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // --- INISIALISASI KOMPONEN BANGUN DATAR (JAJAR GENJANG) ---
        val etAlas = findViewById<EditText>(R.id.etAlas)
        val etTinggi = findViewById<EditText>(R.id.etTinggi)
        val btnHitungDatar = findViewById<Button>(R.id.btnHitungDatar)
        val tvHasilDatar = findViewById<TextView>(R.id.tvHasilDatar)

        // --- INISIALISASI KOMPONEN BANGUN RUANG (KUBUS) ---
        val etSisi = findViewById<EditText>(R.id.etSisi)
        val btnHitungRuang = findViewById<Button>(R.id.btnHitungRuang)
        val tvHasilRuang = findViewById<TextView>(R.id.tvHasilRuang)

        // LOGIKA HITUNG LUAS JAJAR GENJANG
        btnHitungDatar.setOnClickListener {
            val alasStr = etAlas.text.toString()
            val tinggiStr = etTinggi.text.toString()

            if (alasStr.isNotEmpty() && tinggiStr.isNotEmpty()) {
                val alas = alasStr.toDouble()
                val tinggi = tinggiStr.toDouble()
                val luas = alas * tinggi

                tvHasilDatar.text = "Hasil Luas: $luas"

                // Praktikum Logcat: Mencatat hasil ke Logcat (Debug)
                Log.d("PENGHITUNG_APP", "Menghitung Jajar Genjang: $alas * $tinggi = $luas")
            } else {
                tvHasilDatar.text = "Mohon isi semua input!"
            }
        }

        // LOGIKA HITUNG VOLUME KUBUS
        btnHitungRuang.setOnClickListener {
            val sisiStr = etSisi.text.toString()

            if (sisiStr.isNotEmpty()) {
                val sisi = sisiStr.toDouble()
                val volume = sisi * sisi * sisi

                tvHasilRuang.text = "Hasil Volume: $volume"

                // Praktikum Logcat: Mencatat hasil ke Logcat (Info)
                Log.i("PENGHITUNG_APP", "Menghitung Volume Kubus: $sisi^3 = $volume")
            } else {
                tvHasilRuang.text = "Mohon isi panjang sisi!"
            }
        }

    }
}