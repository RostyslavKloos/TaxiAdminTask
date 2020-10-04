package com.example.taxiadmintask.ui.adapter

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.util.SparseArray
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.taxiadmintask.ui.fragments.PlaceholderFragment
import com.example.taxiadmintask.ui.fragments.PlaceholderFragment.Companion.newInstance
import com.example.taxiadmintask.utils.SessionManager

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private lateinit var sessionManager: SessionManager

    override fun getPageTitle(position: Int): CharSequence? {
        sessionManager = SessionManager(context)
        val tokens = sessionManager.fetchAuthToken()
        return tokens?.elementAt(position)
    }

    override fun getItem(position: Int): Fragment {
        sessionManager = SessionManager(context)
        val tokens = sessionManager.fetchAuthToken()
        //return newInstance(tokens?.elementAt(position)!!)
        val bundle = Bundle()
        val data = bundle.getSerializable("postResponse")
        return newInstance(data!!)
    }

    override fun getCount(): Int {
        sessionManager = SessionManager(context)
        return sessionManager.fetchAuthToken()!!.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)
    }
}