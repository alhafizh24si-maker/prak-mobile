package com.example.hafizh_cool

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.hafizh_cool.databinding.ActivityCustomOneBinding

class CustomOneActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi View Binding
        binding = ActivityCustomOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e("Lifecycle", "CustomOneActivity: onCreate dibuat")

        // 1. Ambil data dari Intent dengan nilai default agar tidak null
        val judul = intent.getStringExtra("EXTRA_TITLE") ?: "Detail Fitur"
        val deskripsi = intent.getStringExtra("EXTRA_DESC") ?: "Deskripsi tidak tersedia."

        // 2. Tampilkan data ke TextView sesuai ID di XML terbaru
        // tvTitleHalaman tetap ada di XML
        binding.tvTitleHalaman.text = judul

        // tvDescHalaman diubah menjadi tvDescription sesuai XML terbaru
        binding.tvDescription.text = deskripsi

        // 3. Logika Tombol Kembali (Floating Action Button di bawah)
        binding.btnBack.setOnClickListener {
            finish()
        }

        // 4. Logika Tombol Back di pojok kiri atas (Ikon)
        binding.btnBackIcon.setOnClickListener {
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Lifecycle", "CustomOneActivity: onDestroy dihapus")
    }
}