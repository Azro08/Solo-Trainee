package com.example.desingtasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.core.view.MenuProvider
import com.example.desingtasks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding : ActivityMainBinding?=null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setMenu()
    }

    private fun setMenu() {
        addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                val fragmentManager = supportFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()

                when (menuItem.itemId){
                    R.id.itemCenteringElements -> {
                        val newFragment = CenteringElementsFragment()
                        fragmentTransaction.replace(R.id.fragmentContainer, newFragment)
                        fragmentTransaction.commit()
                    }

                    R.id.itemScrollView -> {
                        val newFragment = ScrollViewFragment()
                        fragmentTransaction.replace(R.id.fragmentContainer, newFragment)
                        fragmentTransaction.commit()
                    }

                    R.id.itemZorder1 ->{
                        val newFragment = ZorderOneFragment()
                        fragmentTransaction.replace(R.id.fragmentContainer, newFragment)
                        fragmentTransaction.commit()
                    }

                    R.id.itemZorder2 ->{
                        val newFragment = ZorderTwoFragment()
                        fragmentTransaction.replace(R.id.fragmentContainer, newFragment)
                        fragmentTransaction.commit()
                    }
                }
                return true
            }
        })
    }


}