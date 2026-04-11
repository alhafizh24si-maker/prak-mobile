package com.example.hafizh_cool

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.hafizh_cool.databinding.ActivityCustomTwoBinding

class CustomTwoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCustomTwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Inisialisasi View Binding
        binding = ActivityCustomTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e("Lifecycle", "CustomTwoActivity: onCreate dipanggil")

        // 2. Ambil data dari Intent (jika dikirim dari MainActivity)
        // Kita gunakan data default jika intent kosong agar aplikasi tidak crash
        val judul = intent.getStringExtra("EXTRA_TITLE") ?: "Profil Saya"
        val namaUser = intent.getStringExtra("EXTRA_NAME") ?: "User Globy"
        val emailUser = intent.getStringExtra("EXTRA_EMAIL") ?: "user.globy@email.com"

        // 3. Tampilkan data ke komponen UI sesuai ID di XML terbaru
        binding.tvTitleHalaman.text = judul
        binding.tvProfileName.text = namaUser
        binding.tvProfileEmail.text = emailUser

        // Opsional: Jika Anda ingin mengisi detail kartu dari Intent
        binding.tvFullNameDisplay.text = intent.getStringExtra("EXTRA_FULL_NAME") ?: "Globy User Indonesia"
        binding.tvPhoneDisplay.text = intent.getStringExtra("EXTRA_PHONE") ?: "+62 812 3456 7890"

        // 4. Logika Tombol Kembali (Ikon di atas)
        binding.btnBackIcon.setOnClickListener {
            finish()
        }

        // 5. Logika Tombol Kembali (Button besar di bawah)
        binding.btnBack.setOnClickListener {
            finish()
        }

        // 6. Logika Tombol Edit Foto (Floating Action Button)
        binding.btnEditPhoto.setOnClickListener {
            // Tambahkan logika untuk mengganti foto di sini jika diperlukan
            Log.d("Profile", "Tombol edit foto diklik")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Lifecycle", "CustomTwoActivity: onDestroy (Activity dihancurkan)")
    }
}