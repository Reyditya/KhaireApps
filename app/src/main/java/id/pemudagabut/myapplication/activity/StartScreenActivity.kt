package id.pemudagabut.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.cardview.widget.CardView
import id.pemudagabut.myapplication.R
import id.pemudagabut.myapplication.helper.SharedPref
import org.jetbrains.anko.startActivity

class StartScreenActivity : AppCompatActivity() {
    lateinit var cvMasuk: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_screen)

        cvMasuk = findViewById(R.id.cvMasuk)

        cvMasuk.setOnClickListener {
            startActivity<MasukScreenActivity>()
            finish()
        }
    }

    fun daftar(view: View) {
        startActivity<DaftarScreenActivity>()
        finish()
    }
}