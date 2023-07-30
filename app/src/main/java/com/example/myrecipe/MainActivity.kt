package com.example.myrecipe

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView = findViewById<ListView>(R.id.listview)
        listView.adapter=MyCustomAdapter(this)


    }
    private class MyCustomAdapter(context: Context):BaseAdapter(){
        private val recipenames= arrayListOf<String>(
            "pulled_pork","bhajia","Ugali","Rice","Chapati")
        private var recipeimages= arrayListOf<Int>(
            R.drawable.pulled_pork,
            R.drawable.bhajia,
            R.drawable.ugali,
            R.drawable.rice,
            R.drawable.chapati
        )
        private val ncontext : Context
        init{
            ncontext = context
        }

        override fun getCount(): Int {
            return recipenames.size


        }

        override fun getItem(position: Int): Any {
            return "TestString"
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }
        //responsible for rendering row
        @SuppressLint("SetTextI18n", "ViewHolder")
        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            val layoutInflater=LayoutInflater.from(ncontext)
            val activitylistview=layoutInflater.inflate(R.layout.activitylist_view,viewGroup,false)
            val textview=activitylistview.findViewById<TextView>(R.id.textview)
            textview.text=recipenames.get(position)
            val imageview=activitylistview.findViewById<ImageView>(R.id.imageview)
            imageview.setImageResource(recipeimages.get(position))


            return activitylistview

        }

    }
}