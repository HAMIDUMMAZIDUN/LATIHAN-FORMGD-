package edu.hamidabdulaziz.formfgd

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var btnInfo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        tvResult = findViewById(R.id.tvResult)
        btnInfo = findViewById(R.id.btnInfo)

        // Ambil data dari Intent
        val nama = intent.getStringExtra("nama") ?: "-"
        val noHP = intent.getStringExtra("noHP") ?: "-"
        val email = intent.getStringExtra("email") ?: "-"
        val gender = intent.getStringExtra("gender") ?: "-"
        val skills = intent.getStringExtra("skills") ?: "-"
        val kategori = intent.getStringExtra("kategori") ?: "-"

        // Buat tampilan hasil
        val hasil = """
            Nama: $nama
            No HP: $noHP
            Email: $email
            Gender: $gender
            Skills: $skills
            Kategori: $kategori
        """.trimIndent()

        tvResult.text = hasil

        // Tombol Info Pengembang
        btnInfo.setOnClickListener {
            val intent = Intent(this, DeveloperInfoActivity::class.java)
            startActivity(intent)
        }
    }
}
