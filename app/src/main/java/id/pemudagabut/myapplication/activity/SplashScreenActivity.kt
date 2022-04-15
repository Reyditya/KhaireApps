package id.pemudagabut.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import id.pemudagabut.myapplication.R
import id.pemudagabut.myapplication.helper.SharedPref
import org.jetbrains.anko.startActivity

class SplashScreenActivity : AppCompatActivity() {
    //inisialisasi variable
    lateinit var s: SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        //deklarasi variable
        s = SharedPref(this)

        //penggunaan variable di dalam kode splashscreen
        Handler().postDelayed({
            finish()
            if (s.getStatusLogin()){
                Log.d(s.getStatusLogin().toString(), "dah login")
                startActivity<MainActivity>()
            }else {
                startActivity<StartScreenActivity>()
            }
        },2000)

    }
}