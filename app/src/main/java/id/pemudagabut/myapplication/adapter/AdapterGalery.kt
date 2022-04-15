package id.pemudagabut.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.pemudagabut.myapplication.R
import id.pemudagabut.myapplication.model.ModelGalery

class AdapterGalery(var data: ArrayList<ModelGalery>) :
    RecyclerView.Adapter<AdapterGalery.GaleryViewHolder>() {
    class GaleryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val namaMandor = view.findViewById<TextView>(R.id.namaMandor)
        val hasilMandor = view.findViewById<TextView>(R.id.hasilMandor)
        val gambar = view.findViewById<ImageView>(R.id.gambar)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GaleryViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list_galery, parent, false)

        return GaleryViewHolder(view)
    }

    override fun onBindViewHolder(holder: GaleryViewHolder, position: Int) {
        holder.namaMandor.text = data[position].namaMandor
        holder.hasilMandor.text = data[position].hasilMandor
        holder.gambar.setImageResource(data[position].gambar)

    }

    override fun getItemCount(): Int {
        return data.size
    }


}