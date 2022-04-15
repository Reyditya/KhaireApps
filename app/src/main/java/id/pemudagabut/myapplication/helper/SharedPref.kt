package id.pemudagabut.myapplication.helper

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import id.pemudagabut.myapplication.model.ModelUser

class SharedPref(activity: Activity) {

    // Shared Preference merupakan media penyimpanan data primitif
    // pada file internal pada aplikasi dalam bentuk key-value
    // contohnya saya memggunakan shared pref untuk menyimpan data "Login"

    val login = "login"
//    val nama = "name"
//    val phone = "phone"
//    val email = "email"
    val modelUser = "modelUser"


    val myPref = "MAIN_PREF"
    val sp: SharedPreferences

    init {
        sp = activity.getSharedPreferences(myPref, Context.MODE_PRIVATE)
    }

    fun setStatusLogin(status: Boolean) {
        sp.edit().putBoolean(login, status).apply()
    }

    fun getStatusLogin(): Boolean {
        return sp.getBoolean(login, false)
    }

    fun setUser(value: ModelUser){
        val data: String = Gson().toJson(value, ModelUser::class.java)
        sp.edit().putString(modelUser, data).apply()
    }

    fun getUser(): ModelUser?{
        val data:String = sp.getString(modelUser, null) ?:return null
        return Gson().fromJson<ModelUser>(data, ModelUser::class.java)
    }

    fun setString(key: String, value: String){
        sp.edit().putString(key, value).apply()
    }

    fun getString(key: String): String{

        return sp.getString(key, "")!!

    }


}