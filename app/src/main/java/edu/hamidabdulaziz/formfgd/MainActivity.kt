package edu.hamidabdulaziz.formfgd

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etNama: EditText
    private lateinit var etNoHP: EditText
    private lateinit var etEmail: EditText
    private lateinit var rgGender: RadioGroup
    private lateinit var cbAlgoritma: CheckBox
    private lateinit var cbProblemSolving: CheckBox
    private lateinit var cbCriticalThinking: CheckBox
    private lateinit var cbProgramming: CheckBox
    private lateinit var cbDesignThinking: CheckBox
    private lateinit var spinnerKategori: Spinner
    private lateinit var btnSimpan: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNama = findViewById(R.id.etNama)
        etNoHP = findViewById(R.id.etNoHP)
        etEmail = findViewById(R.id.etEmail)
        rgGender = findViewById(R.id.rgGender)
        cbAlgoritma = findViewById(R.id.cbAlgoritma)
        cbProblemSolving = findViewById(R.id.cbProblemSolving)
        cbCriticalThinking = findViewById(R.id.cbCriticalThinking)
        cbProgramming = findViewById(R.id.cbProgramming)
        cbDesignThinking = findViewById(R.id.cbDesignThinking)
        spinnerKategori = findViewById(R.id.spinnerKategori)
        btnSimpan = findViewById(R.id.btnSimpan)

        // Spinner data
        val kategoriList = arrayOf("Akademisi", "Praktisi", "Mahasiswa", "Umum")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, kategoriList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerKategori.adapter = adapter

        btnSimpan.setOnClickListener {
            val nama = etNama.text.toString()
            val noHP = etNoHP.text.toString()
            val email = etEmail.text.toString()

            val selectedGenderId = rgGender.checkedRadioButtonId
            val gender = findViewById<RadioButton>(selectedGenderId)?.text ?: "Belum dipilih"

            val skills = mutableListOf<String>()
            if (cbAlgoritma.isChecked) skills.add("Algoritma")
            if (cbProblemSolving.isChecked) skills.add("Problem Solving")
            if (cbCriticalThinking.isChecked) skills.add("Critical Thinking")
            if (cbProgramming.isChecked) skills.add("Programming")
            if (cbDesignThinking.isChecked) skills.add("Design Thinking")

            val kategori = spinnerKategori.selectedItem.toString()

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("nama", nama)
            intent.putExtra("noHP", noHP)
            intent.putExtra("email", email)
            intent.putExtra("gender", gender.toString())
            intent.putExtra("skills", skills.joinToString())
            intent.putExtra("kategori", kategori)
            startActivity(intent)
        }
    }
}
