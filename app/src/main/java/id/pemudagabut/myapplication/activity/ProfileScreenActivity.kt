package id.pemudagabut.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import id.pemudagabut.myapplication.R
import id.pemudagabut.myapplication.helper.SharedPref
import org.jetbrains.anko.startActivity

class ProfileScreenActivity : AppCompatActivity() {
    // inisialisasi variable
    lateinit var llKeluar: LinearLayout
    lateinit var s: SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_screen)

        s = SharedPref(this)
        llKeluar = findViewById(R.id.ll_keluar)


        // kode keluar akun
        llKeluar.setOnClickListener {
            s.setStatusLogin(false)
            Log.d(s.setStatusLogin(false).toString(), "keluar")
            Toast.makeText(this, "Berhasil Keluar Akun", Toast.LENGTH_LONG).show()
            startActivity<StartScreenActivity>()

        }

    }

    // function2 yang di butuhkan

    fun keTentang(view: View) {
        startActivity<TentangScreenActivity>()
    }

    fun back(view: View) {
        startActivity<MainActivity>()
    }

    fun keUpdateProfile(view: View) {
        startActivity<UpdateProfileScreenActivity>()
    }
}