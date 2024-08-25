package br.edu.ifsp.HaVagas

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.ifsp.HaVagas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var amb: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        amb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(amb.root)

        val emailList = mutableListOf<String>()

        amb.limparBt.setOnClickListener {
            limpar()
        }

        amb.salvarBt.setOnClickListener {

        }
    }

    private fun limpar() {
        amb.nomeEt.text.clear()
        amb.telefoneEt.text.clear()
        amb.emailEt.text.clear()
        if (amb.emailCb.isChecked) amb.emailCb.toggle()
        amb.generoRg.clearCheck()
        amb.cidadeEt.text.clear()
    }
}