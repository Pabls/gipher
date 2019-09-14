package ru.ar4i.gipher.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.ar4i.gipher.R
import ru.ar4i.gipher.presentation.base.view.BaseFragment
import ru.ar4i.gipher.presentation.gifs.GifsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            showFragment(GifsFragment.newInstance())
        }
    }

    private fun showFragment(fragment: BaseFragment) {
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
            .replace(R.id.fl_container, fragment)
            .commit()
    }
}
