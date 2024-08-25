package br.edu.ifsp.HaVagas

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import br.edu.ifsp.HaVagas.databinding.ActivityMainBinding
import java.util.Calendar

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