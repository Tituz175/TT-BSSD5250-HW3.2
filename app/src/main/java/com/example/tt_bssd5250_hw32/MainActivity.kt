package com.example.tt_bssd5250_hw32

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.RawContacts.Data
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResultListener

class MainActivity : AppCompatActivity() {
    var noteTotal = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fragmentLinearLayout = LinearLayoutCompat(this).apply {
            id = View.generateViewId()
            orientation = LinearLayoutCompat.VERTICAL
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
            )
        }

        val addButton = Button(this).apply {
            text = "+"
            layoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            )
            setOnClickListener {
                noteTotal++
                if (noteTotal < 11) {
                    supportFragmentManager.commit {
                        setReorderingAllowed(true)
                        add(fragmentLinearLayout.id, NoteFragment.newInstance(), null)
                    }
                }
            }
        }


        val linearLayout = LinearLayoutCompat(this).apply {
            setBackgroundColor(Color.LTGRAY)
            orientation = LinearLayoutCompat.VERTICAL
            addView(addButton)
            addView(fragmentLinearLayout)
        }

        setContentView(linearLayout)

    }
}