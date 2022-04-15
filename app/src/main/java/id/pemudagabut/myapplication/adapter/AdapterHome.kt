package id.pemudagabut.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.pemudagabut.myapplication.R
import id.pemudagabut.myapplication.model.ModelHome

class AdapterHome(var dataList: ArrayList<ModelHome>) :
    RecyclerView.Adapter<AdapterHome.HomeViewHolder>() {
    class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val gambarHome: ImageView = view.findViewById(R.id.gambarHome)
        val mandorHome: TextView = view.findViewById(R.id.mandorHome)
        val umurHome: TextView = view.findViewById(R.id.umurHome)
        val profesiHome: TextView = view.findViewById(R.id.profesiHome)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list_home, parent, false)


        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.gambarHome.setImageResource(dataList[position].gambarHome)
        holder.mandorHome.text = dataList[position].mandorHome
        holder.umurHome.text = dataList[position].umurHome
        holder.profesiHome.text = dataList[position].profesiHome

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

}