package br.edu.ifsp.HaVagas

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.HaVagas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var amb: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        amb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(amb.root)

        val emailList = mutableListOf<String>()

        amb.celularCb.setOnClickListener{
            if(amb.celularCb.isChecked){
                amb.celularTv.visibility = View.VISIBLE
                amb.celularEt.visibility = View.VISIBLE
            }
        }

        amb.limparBt.setOnClickListener {
            limpar()
        }

        amb.salvarBt.setOnClickListener {

        }
    }

    private fun limpar() {

    }
}