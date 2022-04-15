package id.pemudagabut.myapplication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.pemudagabut.myapplication.R
import id.pemudagabut.myapplication.adapter.AdapterGalery
import id.pemudagabut.myapplication.model.ModelGalery


class GaleryFragment : Fragment() {
    lateinit var rvGalery: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_galery, container, false)


        rvGalery = view.findViewById(R.id.rvGalery)

        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        rvGalery.adapter = AdapterGalery(arrGalery)
        rvGalery.layoutManager = layoutManager



        return view
    }

    val arrGalery: ArrayList<ModelGalery> get() {
        val arr = ArrayList<ModelGalery>()
        val modelGalery1 = ModelGalery()
        modelGalery1.gambar = R.drawable.list
        modelGalery1.namaMandor = "Kasim"
        modelGalery1.hasilMandor = "Renovasi kamar mandi"

        val modelGalery2 = ModelGalery()
        modelGalery2.namaMandor = "Marno"
        modelGalery2.hasilMandor = "Memperbaiki wc"
        modelGalery2.gambar = R.drawable.list

        val modelGalery3 = ModelGalery()
        modelGalery3.namaMandor = "Darso"
        modelGalery3.hasilMandor = "Membuat taman di belakang rumah"
        modelGalery3.gambar = R.drawable.list

        val modelGalery4 = ModelGalery()
        modelGalery4.namaMandor = "Lakimin"
        modelGalery4.hasilMandor = "Membuat pagar besi"
        modelGalery4.gambar = R.drawable.list

        arr.add(modelGalery1)
        arr.add(modelGalery2)
        arr.add(modelGalery3)
        arr.add(modelGalery4)

        return arr


    }

}