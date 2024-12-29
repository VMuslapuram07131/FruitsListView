package com.example.fruitslistview

import android.content.Context
import android.database.DataSetObserver
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity() : AppCompatActivity(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val players = arrayOf(

            "dhoni",

            "rohit",
            "ronaldo",

            "virat",
            "yashasvi"
            )

//        val listView:ListView = findViewById(R.id.playerList)
//        val adapter:ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, players)
//        listView.adapter = adapter

        val player_image = arrayOf<Int>(

            R.drawable.dhoni,

            R.drawable.rohit,
            R.drawable.ronaldo,

            R.drawable.virat,
            R.drawable.yashasvi
        )
        val listView:ListView = findViewById(R.id.playerList)
        val adapter:playeradapter = playeradapter(this, players, player_image)
        listView.adapter = adapter

    }

    class playeradapter(val context: Context, val player:Array<String>, val player_image:Array<Int>):BaseAdapter()
    {
        override fun getCount(): Int {
            return player.size
        }

        override fun getItem(p0: Int): Any {
            return p0.toInt()
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val view:View = LayoutInflater.from(context).inflate(R.layout.playeritem, p2, false)
            val imageView:ImageView = view.findViewById(R.id.imageView)
            val textView: TextView = view.findViewById(R.id.playernameview)
            imageView.setImageResource(player_image[p0])
            textView.text = player[p0]
            return view
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }

}

