package edu.hamidabdulaziz.formfgd

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DeveloperInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_developer)

        val tvInfo = findViewById<TextView>(R.id.tvDeveloper)
        tvInfo.text = """
            Created By:
            NIM : 10110269
            NAMA : Rizki Adem Kurniawan

            Email Saya :
            rizki.akurniawan@email.unikom.ac.id

            Youtube Saya
            https://www.youtube.com/@rizkiademkurniawan8277
        """.trimIndent()
    }
}
