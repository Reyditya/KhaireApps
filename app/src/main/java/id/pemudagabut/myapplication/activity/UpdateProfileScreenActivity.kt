package id.pemudagabut.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import id.pemudagabut.myapplication.R
import id.pemudagabut.myapplication.helper.SharedPref
import org.jetbrains.anko.startActivity

class UpdateProfileScreenActivity : AppCompatActivity() {
    lateinit var s: SharedPref
    lateinit var edtunup: EditText
    lateinit var edemailup: EditText
    lateinit var edtnohpup: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_profile_screen)
        s = SharedPref(this)
        setData()
    }

    private fun setData() {
        edtunup = findViewById(R.id.edtUnup)
        edtnohpup = findViewById(R.id.edtnohpup)
        edemailup = findViewById(R.id.edtemailup)

        val modelUser = s.getUser()!!
        edtunup.setText(modelUser.name)
        edtnohpup.setText(modelUser.phone)
        edemailup.setText(modelUser.email)
    }

    fun back(view: View) {
        startActivity<ProfileScreenActivity>()
    }
}