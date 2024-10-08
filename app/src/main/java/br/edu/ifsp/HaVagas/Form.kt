package br.edu.ifsp.HaVagas

import java.util.Date

class Form(
    var name: String?,
    var email: String?,
    var phone: String?,
    var cellphone: String?,
    var gender: String?,
    var birthdate: Date?,
    var schoolLevel: String?,
    var graduationYear: Int?,
    var conclusionYear: Int?,
    var institution: String?,
    var monography: String?,
    var tutor: String?,
    var positions: String?,
    var mailingList: Boolean
) {

    override fun toString(): String {
        return "Form(name=$name, email=$email, phone=$phone, cellphone=$cellphone, gender=$gender, birthdate=$birthdate, schoolLevel=$schoolLevel, graduationYear=$graduationYear, conclusionYear=$conclusionYear, institution=$institution, monography=$monography, tutor=$tutor, positions=$positions)"
    }
}