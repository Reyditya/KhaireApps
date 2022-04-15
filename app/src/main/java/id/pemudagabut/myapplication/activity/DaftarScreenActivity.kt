package id.pemudagabut.myapplication.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import id.pemudagabut.myapplication.Api.ApiConfig
import id.pemudagabut.myapplication.R
import id.pemudagabut.myapplication.helper.SharedPref
import id.pemudagabut.myapplication.model.ModelRespon
import org.jetbrains.anko.startActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DaftarScreenActivity : AppCompatActivity() {
    lateinit var cvDaftar: CardView
    lateinit var edtUsername: EditText
    lateinit var edtEmail: EditText
    lateinit var edtNoHp: EditText
    lateinit var edtPassword: EditText
    lateinit var s: SharedPref
    lateinit var pb1: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_screen)
        s = SharedPref(this)


        pb1 = findViewById(R.id.pb1)
        edtUsername = findViewById(R.id.edt_username)
        edtEmail = findViewById(R.id.edt_email)
        edtNoHp = findViewById(R.id.edt_nohp)
        edtPassword = findViewById(R.id.edt_password)
        cvDaftar = findViewById(R.id.cvDaftar)
        cvDaftar.setOnClickListener {
            daftar()
        }

    }

    fun daftar() {

        if (edtUsername.text.isEmpty()) {
            edtUsername.error = "Username tidak boleh kosong"
            edtUsername.requestFocus()
            return
        } else if (edtEmail.text.isEmpty()) {
            edtEmail.error = "Email tidak boleh kosong"
            edtEmail.requestFocus()
            return
        } else if (edtNoHp.text.isEmpty()) {
            edtNoHp.error = "Nomer hp tidak boleh kosong"
            edtNoHp.requestFocus()
            return
        } else if (edtPassword.text.isEmpty()) {
            edtPassword.error = "Password tidak boleh kosong"
            edtPassword.requestFocus()
            return
        }

        pb1.visibility = View.VISIBLE
        ApiConfig.instanceRetrofit.register(
            edtUsername.text.toString(),
            edtEmail.text.toString(),
            edtNoHp.text.toString(),
            edtPassword.text.toString()
        ).enqueue(object : Callback<ModelRespon> {
            override fun onResponse(call: Call<ModelRespon>, response: Response<ModelRespon>) {
                pb1.visibility = View.GONE
                val respon = response.body()!!
                if (respon.success == 1) {
                    s.setStatusLogin(true)
                    s.setUser(respon.user)
                    startActivity<MainActivity>()
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    Toast.makeText(
                        this@DaftarScreenActivity,
                        "Berhasil Daftar, " + respon.user.name,
                        Toast.LENGTH_LONG
                    ).show()
                    finish()
                    onBackPressed()

                } else {
                    Toast.makeText(
                        this@DaftarScreenActivity,
                        "Error:   " + respon.msg,
                        Toast.LENGTH_LONG
                    ).show()

                }


            }

            override fun onFailure(call: Call<ModelRespon>, t: Throwable) {
                pb1.visibility = View.GONE
                Toast.makeText(this@DaftarScreenActivity, "Error:" + t.message, Toast.LENGTH_LONG)
                    .show()

            }

        })

    }


    fun back(view: View) {
        startActivity<MasukScreenActivity>()
        finish()
    }
}