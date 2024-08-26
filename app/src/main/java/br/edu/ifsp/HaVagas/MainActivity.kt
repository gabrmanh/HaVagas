package br.edu.ifsp.HaVagas

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.HaVagas.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.Date

class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

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
                if(!isValid(
                        emailEt.text.toString(),
                        telefoneEt.text.toString(),
                        celularEt.text.toString(),
                        dataEt.text.toString(),
                        anoFormaturaEt.text.toString(),
                        anoConclusaoEt.text.toString()
                    )){
                    Toast.makeText(this@MainActivity, "Invalid values", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val mailing = emailCb.isChecked

                val gender = getCheckedRadioButtonText(generoRg)
                val schoolLevel = getCheckedRadioButtonText(formacaoRg)
                val date = parseDate(dataEt.text.toString())

                val graduation = if (anoFormaturaEt.text.toString().isNotBlank())
                    anoFormaturaEt.text.toString().toInt() else null

                val conclusion = if (anoConclusaoEt.text.toString().isNotBlank())
                    anoConclusaoEt.text.toString().toInt() else null

                val form = Form(nomeEt.text.toString(), emailEt.text.toString(), telefoneEt.text.toString(),
                    celularEt.text.toString(), gender, date, schoolLevel, graduation,
                    conclusion, instituicaoEt.text.toString(), monografiaEt.text.toString(),
                    orientadorEt.text.toString(), vagasEt.text.toString(), mailing)

                showFormPopup(form)
            }
        }
    }

    private fun getCheckedRadioButtonText(rg: RadioGroup): String? {
        val checkedId = rg.checkedRadioButtonId
        if (checkedId != -1) {
            val radioButton = findViewById<RadioButton>(checkedId)
            return radioButton.text.toString()
        }
        return null
    }

    private fun parseDate(dateString: String): Date? {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        return try {
            dateFormat.parse(dateString)
        } catch (e: Exception) {
            null
        }
    }

    private fun showFormPopup(form: Form) {
        val formDetails = StringBuilder()

        form.name?.let { formDetails.append("Name: $it\n") }
        form.email?.let { formDetails.append("Email: $it\n") }
        form.phone?.let { formDetails.append("Phone: $it\n") }
        form.cellphone?.let { formDetails.append("Cellphone: $it\n") }
        form.gender?.let { formDetails.append("Gender: $it\n") }
        form.birthdate?.let { formDetails.append("Birthdate: $it\n") }
        form.schoolLevel?.let { formDetails.append("School Level: $it\n") }
        form.graduationYear?.let { formDetails.append("Graduation Year: $it\n") }
        form.conclusionYear?.let { formDetails.append("Conclusion Year: $it\n") }
        form.institution?.let { formDetails.append("Institution: $it\n") }
        form.monography?.let { formDetails.append("Monography: $it\n") }
        form.tutor?.let { formDetails.append("Tutor: $it\n") }
        form.positions?.let { formDetails.append("Positions: $it\n") }
        form.mailingList.let { formDetails.append("Mail list enabled?: ${it}\n") }

        AlertDialog.Builder(this)
            .setTitle("Form Details")
            .setMessage(formDetails.toString().trim())
            .setPositiveButton("OK", null)
            .show()
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

    private fun isValid(
        email: String?, phone: String?, cellphone: String?, date: String?,
        graduation: String?, conclusion: String?
    ): Boolean {

        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex()
        val phoneRegex = "^\\d{10,11}$".toRegex()
        val dateRegex = "^\\d{2}/\\d{2}/\\d{4}$".toRegex()
        val yearRegex = "^\\d{4}$".toRegex()

        return (email.isNullOrBlank() || email.matches(emailRegex)) &&
                (phone.isNullOrBlank() || phone.matches(phoneRegex)) &&
                (cellphone.isNullOrBlank() || cellphone.matches(phoneRegex)) &&
                (date.isNullOrBlank() || date.matches(dateRegex)) &&
                (graduation.isNullOrBlank() || graduation.matches(yearRegex)) &&
                (conclusion.isNullOrBlank() || conclusion.matches(yearRegex))
    }
}