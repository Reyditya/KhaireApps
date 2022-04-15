package id.pemudagabut.myapplication.activity

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import id.pemudagabut.myapplication.Api.ApiConfig
import id.pemudagabut.myapplication.R
import id.pemudagabut.myapplication.helper.SharedPref
import id.pemudagabut.myapplication.model.ModelRespon
import org.jetbrains.anko.startActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MasukScreenActivity : AppCompatActivity() {
    lateinit var s: SharedPref
    lateinit var edtmsk_username: EditText
    lateinit var edtmsk_password: EditText
    lateinit var pb: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_masuk_screen)
        s = SharedPref(this)
        edtmsk_username = findViewById(R.id.edtmsk_username)
        edtmsk_password = findViewById(R.id.edtmsk_password)
        pb = findViewById(R.id.pb)

    }

    fun masuk2(view: View) {
//        s.setStatusLogin(true)
//        Toast.makeText(this, "Anda Berhasil Masuk", Toast.LENGTH_SHORT).show()
//        startActivity<MainActivity>()

        if (edtmsk_username.text.isEmpty()) {
            edtmsk_username.error = "Username tidak boleh kosong"
            edtmsk_username.requestFocus()
            return
        } else if (edtmsk_password.text.isEmpty()) {
            edtmsk_password.error = "Password tidak boleh kosong"
            edtmsk_password.requestFocus()
            return
        }

        pb.visibility = View.VISIBLE
        ApiConfig.instanceRetrofit.login(
            edtmsk_username.text.toString(),
            edtmsk_password.text.toString()
        ).enqueue(object : Callback<ModelRespon> {
            override fun onResponse(call: Call<ModelRespon>, response: Response<ModelRespon>) {
                pb.visibility = View.GONE
                val respon = response.body()!!
                if (respon.success == 1) {
                    s.setStatusLogin(true)
                    s.setUser(respon.user)
                    startActivity<MainActivity>()
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    Toast.makeText(
                        this@MasukScreenActivity,
                        "Selamat Datang, " + respon.user.name,
                        Toast.LENGTH_LONG
                    ).show()
                    finish()
                    onBackPressed()

                } else {
                    Toast.makeText(
                        this@MasukScreenActivity,
                        "Error:   " + respon.msg,
                        Toast.LENGTH_LONG
                    ).show()

                }


            }

            override fun onFailure(call: Call<ModelRespon>, t: Throwable) {
                pb.visibility = View.GONE
                Toast.makeText(this@MasukScreenActivity, "Error:" + t.message, Toast.LENGTH_LONG)
                    .show()

            }

        })

    }

    fun daftar2(view: View) {
        startActivity<DaftarScreenActivity>()
    }

    fun back(view: View) {
        startActivity<StartScreenActivity>()
        finish()
    }
}