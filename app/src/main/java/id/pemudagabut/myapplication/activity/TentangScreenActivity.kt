package id.pemudagabut.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import id.pemudagabut.myapplication.R
import org.jetbrains.anko.startActivity

class TentangScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tentang_screen)
    }

    fun back(view: View) {
        startActivity<ProfileScreenActivity>()
    }
}