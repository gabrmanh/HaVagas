package br.edu.ifsp.HaVagas

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
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
            } else {
                amb.celularTv.visibility = View.GONE
                amb.celularEt.visibility = View.GONE
            }
        }

        amb.formacaoRg.setOnCheckedChangeListener { _, checkedId ->
            showFields(checkedId)
        }

        amb.limparBt.setOnClickListener {
            limpar()
        }

        amb.salvarBt.setOnClickListener {
            amb.apply {
                if(!isValid(nomeEt.text.toString(), emailEt.text.toString(), telefoneEt.text.toString(),
                        celularEt.text.toString(), dataEt.text.toString(), anoFormaturaEt.text.toString(),
                        anoConclusaoEt.text.toString(), instituicaoEt.text.toString(), monografiaEt.text.toString(),
                        orientadorEt.text.toString(), vagasEt.text.toString())){
                    Toast.makeText(this@MainActivity, "Invalid values", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }



            }
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

            else -> {
                amb.anoFormaturaTv.visibility = View.GONE
                amb.anoFormaturaEt.visibility = View.GONE
                amb.anoConclusaoTv.visibility = View.GONE
                amb.anoConclusaoEt.visibility = View.GONE
                amb.instituicaoTv.visibility = View.GONE
                amb.instituicaoEt.visibility = View.GONE
                amb.monografiaTv.visibility = View.GONE
                amb.monografiaEt.visibility = View.GONE
                amb.orientadorTv.visibility = View.GONE
                amb.orientadorEt.visibility = View.GONE
            }
        }
    }

    private fun limpar() {
        amb.nomeEt.text.clear()
        amb.emailEt.text.clear()
        amb.telefoneEt.text.clear()
        amb.telefoneRg.clearCheck()
        amb.celularEt.text.clear()
        amb.generoRg.clearCheck()
        amb.dataEt.text.clear()
        amb.formacaoRg.clearCheck()
        amb.anoFormaturaEt.text.clear()
        amb.anoConclusaoEt.text.clear()
        amb.instituicaoEt.text.clear()
        amb.monografiaEt.text.clear()
        amb.orientadorEt.text.clear()
        amb.vagasEt.text.clear()
    }

    private fun isValid(name: String?, email: String?, phone: String?, cellphone: String?,
                        date: String?, graduation: String?, conclusion: String?,
                        institution: String?, monography: String?, tutor: String?,
                        positions: String?): Boolean{
        val nameRegex = "^[A-Za-z\\s]+$".toRegex()
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex()
        val phoneRegex = "^\\d{10,11}$".toRegex()
        val dateRegex = "^\\d{2}/\\d{2}/\\d{4}$".toRegex()
        val yearRegex = "^\\d{4}$".toRegex()
        val textRegex = "^[A-Za-z0-9\\s]+$".toRegex()

        return (name?.matches(nameRegex) ?: true) &&
                (email?.matches(emailRegex) ?: true) &&
                (phone?.matches(phoneRegex) ?: true) &&
                (cellphone?.matches(phoneRegex) ?: true) &&
                (date?.matches(dateRegex) ?: true) &&
                (graduation?.matches(yearRegex) ?: true) &&
                (conclusion?.matches(yearRegex) ?: true) &&
                (institution?.matches(textRegex) ?: true) &&
                (monography?.matches(textRegex) ?: true) &&
                (tutor?.matches(textRegex) ?: true) &&
                (positions?.matches(textRegex) ?: true)
    }
}