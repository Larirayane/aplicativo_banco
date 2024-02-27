package com.example.aplicativodebanco

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT

class MostrarPixActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_pix)
        setSupportActionBar(findViewById(R.id.toolbar))
        val saldo = intent.getStringExtra("sSaldo")
        var nsaldo = saldo.toString().toDouble()
        val btenviar = findViewById<Button>(R.id.btnenviar)
        val edtchave = findViewById<EditText>(R.id.chavepix)
        btenviar.setOnClickListener {
            val data = Intent()
            val valorPix = findViewById<EditText>(R.id.pagarpix)
            val nvalor = valorPix.text.toString().toDouble()
            if(nsaldo<nvalor) {
                Toast.makeText(this, "Saldo de $nsaldo é insuficiente para o valor de $nvalor", LENGTH_SHORT).show()
            }
            else {
                nsaldo -= nvalor
            }
            if(nsaldo>nvalor) {
                Toast.makeText(this, "Pix realizado com sucesso!", LENGTH_SHORT).show()
            }
            else {
                nsaldo += nvalor
            }
            val txtSaldo = nsaldo.toString()
            data.putExtra("sSaldo", txtSaldo)
            setResult(Activity.RESULT_OK,data)
            Toast.makeText(this, "$nsaldo", LENGTH_SHORT).show()
            valorPix.setText("".toString())
            edtchave.setText("".toString())
            finish()
        }
    }
}