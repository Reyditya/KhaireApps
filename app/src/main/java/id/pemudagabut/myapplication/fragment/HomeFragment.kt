package id.pemudagabut.myapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.pemudagabut.myapplication.R
import id.pemudagabut.myapplication.adapter.AdapterHome
import id.pemudagabut.myapplication.model.ModelHome

class HomeFragment : Fragment() {
    lateinit var rvHome: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        rvHome = view.findViewById(R.id.rvHome)

        GridLayoutManager(view.context, 2, RecyclerView.VERTICAL, false).apply {
            rvHome.layoutManager = this
        }
        rvHome.adapter = AdapterHome(arrHome)


        return view
    }

    val arrHome: ArrayList<ModelHome>
        get() {
            val arr1 = ArrayList<ModelHome>()
            val modelHome1 = ModelHome()
            modelHome1.gambarHome = R.drawable.default_pic
            modelHome1.mandorHome = "Danum Dinarta"
            modelHome1.umurHome = "23 thn"
            modelHome1.profesiHome = "Mandor"


            val modelHome2 = ModelHome()
            modelHome2.gambarHome = R.drawable.default_pic
            modelHome2.mandorHome = "Dul Adul"
            modelHome2.umurHome = "21 thn"
            modelHome2.profesiHome = "Mandor"

            val modelHome3 = ModelHome()
            modelHome3.gambarHome = R.drawable.default_pic
            modelHome3.mandorHome = "Sajikin Ahmad"
            modelHome3.umurHome = "30 thn"
            modelHome3.profesiHome = "Mandor"

            val modelHome4 = ModelHome()
            modelHome4.gambarHome = R.drawable.default_pic
            modelHome4.mandorHome = "Konila Lana"
            modelHome4.umurHome = "50 thn"
            modelHome4.profesiHome = "Mandor"

            val modelHome5 = ModelHome()
            modelHome5.gambarHome = R.drawable.default_pic
            modelHome5.mandorHome = "Konila Lana"
            modelHome5.umurHome = "50 thn"
            modelHome5.profesiHome = "Mandor"

            val modelHome6 = ModelHome()
            modelHome6.gambarHome = R.drawable.default_pic
            modelHome6.mandorHome = "Konila Lana"
            modelHome6.umurHome = "50 thn"
            modelHome6.profesiHome = "Mandor"

            val modelHome7 = ModelHome()
            modelHome7.gambarHome = R.drawable.default_pic
            modelHome7.mandorHome = "Konila Lana"
            modelHome7.umurHome = "50 thn"
            modelHome7.profesiHome = "Mandor"

            arr1.add(modelHome1)
            arr1.add(modelHome2)
            arr1.add(modelHome3)
            arr1.add(modelHome4)
            arr1.add(modelHome5)
            arr1.add(modelHome6)
            arr1.add(modelHome7)

            return arr1

        }

}