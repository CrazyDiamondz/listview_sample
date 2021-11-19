package com.project.mylistviewsample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)

        listView.adapter = MyCustomListview(this)
    }

    private class MyCustomListview(context: Context) : BaseAdapter() {

        private val mContext : Context

        private val names = arrayListOf<String>("Louie", "BBM", "Sample","Marvin","Jessy")

        init {
            mContext = context
        }


        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getItem(position: Int): Any {
            return "Hello"
        }

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {


            val layoutInflater = LayoutInflater.from(mContext)
            val rowMain = layoutInflater.inflate(R.layout.row_main, viewGroup, false)


            //name
            val nameTextView = rowMain.findViewById<TextView>(R.id.name_textView)
            nameTextView.text = names.get(position)

            //description
            val positionTextView = rowMain.findViewById<TextView>(R.id.position_textView)
            positionTextView.text = "ITEM NUMBER: $position"

            return  rowMain

            //  val textView = TextView(mContext)
            // textView.text = "This is Listview"
            //  return textView

        }

        override fun getCount(): Int {
            return names.size
            //return 5
        }
    }

}