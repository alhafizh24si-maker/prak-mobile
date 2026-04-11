package com.example.hafizh_cool

import android.content.Intent
import android.os.Bundle
import android.widget.Toast

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.hafizh_cool.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Inisialisasi View Binding
        binding = ActivityLoginBinding.inflate(layoutInflater)

        // 2. Gunakan binding.root, JANGAN R.layout.activity_login
        setContentView(binding.root)

        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 3. Logika Klik Tombol
        binding.buttonMasuk.setOnClickListener {
            val email = binding.editTextTextEmailAddress.text.toString()
            val password = binding.editTextTextPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show()

                // PINDAH KE MAIN ACTIVITY (DASHBOARD)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

                // Sesuai materi Lifecycle: finish() agar user tidak bisa kembali ke Login via tombol Back
                finish()
            } else {
                Toast.makeText(this, "Harap isi semua kolom!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}