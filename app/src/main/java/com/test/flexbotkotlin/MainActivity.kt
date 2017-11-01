package com.test.flexbotkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.google.android.flexbox.FlexboxLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flexbox = findViewById<FlexboxLayout>(R.id.flexbox)

        // Comment these lines to use XML layout
        flexbox.removeAllViews()
        for (i in 1..4) {
            flexbox.addView(makeSquareView(i))
        }
    }

    private val widthDp = 30f
    private val heightDp = 30f
    private val marginDp = 6f

    private fun makeSquareView(number: Int): View {

        val scale = resources.displayMetrics.density
        val widthPx = (widthDp * scale).toInt()
        val heightPx = (heightDp * scale).toInt()
        val marginPx = (marginDp * scale).toInt()

        val params = FlexboxLayout.LayoutParams(widthPx, heightPx)
        params.setMargins(0, 0, marginPx, marginPx)

        val view = TextView(this)
        view.layoutParams = params
        view.text = number.toString()
        view.setBackgroundColor(resources.getColor(R.color.colorPrimary))

        return view
    }
}