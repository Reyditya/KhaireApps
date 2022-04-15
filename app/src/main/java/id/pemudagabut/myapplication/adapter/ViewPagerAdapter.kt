package id.pemudagabut.myapplication.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import id.pemudagabut.myapplication.fragment.GaleryFragment
import id.pemudagabut.myapplication.fragment.HomeFragment
import java.lang.IllegalStateException


class ViewPagerAdapter(
    private val context: Context,
    fragmentManager: FragmentManager,
    internal var totalTabs: Int
) : FragmentPagerAdapter(fragmentManager) {

    override fun getCount(): Int {
        return totalTabs
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return HomeFragment()
            } 1 -> {
                return GaleryFragment()
            }
            else -> throw IllegalStateException("$position is illegal")
        }
    }

}
