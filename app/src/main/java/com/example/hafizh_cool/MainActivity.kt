package com.example.hafizh_cool

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.hafizh_cool.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e("Lifecycle", "MainActivity: onCreate")

        // Tombol 1: Rumus Bangun Ruang (Kalkulator)
        binding.btnRumus.setOnClickListener {
            val intent = Intent(this, kalkulator::class.java)
            intent.putExtra("EXTRA_TITLE", "Kalkulator Geometri")
            intent.putExtra("EXTRA_DESC", "Hitung Luas Jajar Genjang & Volume Kubus")
            startActivity(intent)
        }

        // Tombol 2: Custom 1
        binding.btnCustom1.setOnClickListener {
            val intent = Intent(this, CustomOneActivity::class.java)
            intent.putExtra("EXTRA_TITLE", "Halaman Galeri")
            intent.putExtra("EXTRA_DESC", "Menampilkan koleksi gambar pilihan")
            startActivity(intent)
        }

        // Tombol 3: Custom 2
        binding.btnCustom2.setOnClickListener {
            val intent = Intent(this, CustomTwoActivity::class.java)
            intent.putExtra("EXTRA_TITLE", "Informasi Akun")
            intent.putExtra("EXTRA_DESC", "Detail profil dan pengaturan aplikasi")
            startActivity(intent)
        }

        // Tombol 4: Logout (Dialog Konfirmasi)
        binding.btnLogout.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { _, _ ->
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish() // Hapus MainActivity dari stack
                }
                .setNegativeButton("Tidak") { dialog, _ ->
                    dialog.dismiss()
                    Snackbar.make(binding.root, "Logout dibatalkan", Snackbar.LENGTH_SHORT).show()
                }
                .show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Lifecycle", "MainActivity: onDestroy (Dihapus dari stack)")
    }
}