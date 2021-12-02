package com.example.week5day4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private var drawerLT:DrawerLayout? = null
//    التول بار هو المستطيل الي علية اسم الدرس
    private var toolbar1:androidx.appcompat.widget.Toolbar? = null
//
    private var navigation:NavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectViews()
//        سيت سبورت اكشن بار تسمحلي اني احط الخط الي يكون عليه اسم البرنامج و الفائدة هو اني اقدر احط ازرار علية
        setSupportActionBar(toolbar1!!)
//        الكود الي تحت يحطلي زر في الاكشن بار اوبمعنا سطر العنوان
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setupDrawer()
        drawerclick()
    }
    private fun connectViews(){
        drawerLT = findViewById(R.id.drawerL)
        toolbar1 = findViewById(R.id.toolbar)
        navigation = findViewById(R.id.navView)
    }
    private fun setupDrawer(){
      val togalDrawer = ActionBarDrawerToggle(this , drawerLT!!,R.string.open,R.string.close)
        drawerLT?.addDrawerListener(togalDrawer)
        togalDrawer.syncState()
    }
//  الدالة الي تحت هي الي تخلينا نتفاعل مع العناصر الي بداخل الدرور
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
         android.R.id.home ->{
             drawerLT?.openDrawer(GravityCompat.START)
             true
         }
            else->true


        }
    }
    private fun drawerclick(){
        navigation?.setNavigationItemSelectedListener {
//            تعن اذا كان اسم الايتم هو هوم نفذ هذه الاكواد
            when (it.itemId){
                //                    يطبع رسالة ماقتة
                R.id.home -> {Toast.makeText(this,"return to the Home",Toast.LENGTH_LONG).show()
//                    يخلي الدرور ينصك بعد ما اضعط على الايقونة
                    drawerLT?.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.camera ->{
                    //                    يطبع رسالة مؤقتة
                    Toast.makeText(this,"open the camera",Toast.LENGTH_LONG).show()
//                 يخلي الدرور ينصك بعد ما اضعط على الايقونة
                    drawerLT?.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.shir ->{
                    //                    يطبع رسالة ماقتة
                    Toast.makeText(this,"shir",Toast.LENGTH_LONG).show()
                    true
                }
                R.id.shoping ->{
                    //                    يطبع رسالة ماقتة
                    Toast.makeText(this,"go to the shop", Toast.LENGTH_LONG).show()
                    true
                }
                else -> true
            }
        }
    }
}