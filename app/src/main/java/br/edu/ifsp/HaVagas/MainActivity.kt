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

        amb.formacaoRg.setOnCheckedChangeListener { _, checkedId ->
            showFields(checkedId)
        }

        amb.limparBt.setOnClickListener {
            limpar()
        }

        amb.salvarBt.setOnClickListener {

        }
    }

    private fun showFields(checkedId: Int) {
        when (checkedId) {
            R.id.fundamentalRb, R.id.medioRb -> {
                amb.anoFormaturaTv.visibility = View.VISIBLE
                amb.anoFormaturaEt.visibility = View.VISIBLE
                amb.anoConclusaoTv.visibility = View.GONE
                amb.anoConclusaoEt.visibility = View.GONE
                amb.instituicaoTv.visibility = View.GONE
                amb.instituicaoEt.visibility = View.GONE
                amb.monografiaTv.visibility = View.GONE
                amb.monografiaEt.visibility = View.GONE
                amb.orientadorTv.visibility = View.GONE
                amb.orientadorEt.visibility = View.GONE
            }

            R.id.superiorRb, R.id.especializacaoRb -> {
                amb.anoFormaturaTv.visibility = View.GONE
                amb.anoFormaturaEt.visibility = View.GONE
                amb.anoConclusaoTv.visibility = View.VISIBLE
                amb.anoConclusaoEt.visibility = View.VISIBLE
                amb.instituicaoTv.visibility = View.VISIBLE
                amb.instituicaoEt.visibility = View.VISIBLE
                amb.monografiaTv.visibility = View.GONE
                amb.monografiaEt.visibility = View.GONE
                amb.orientadorTv.visibility = View.GONE
                amb.orientadorEt.visibility = View.GONE
            }

            R.id.mestradoRb, R.id.doutoradoRb -> {
                amb.anoFormaturaTv.visibility = View.GONE
                amb.anoFormaturaEt.visibility = View.GONE
                amb.anoConclusaoTv.visibility = View.VISIBLE
                amb.anoConclusaoEt.visibility = View.VISIBLE
                amb.instituicaoTv.visibility = View.VISIBLE
                amb.instituicaoEt.visibility = View.VISIBLE
                amb.monografiaTv.visibility = View.VISIBLE
                amb.monografiaEt.visibility = View.VISIBLE
                amb.orientadorTv.visibility = View.VISIBLE
                amb.orientadorEt.visibility = View.VISIBLE
            }
        }
    }

    private fun limpar() {

    }
}