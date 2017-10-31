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

        flexbox.removeAllViews()
        for (i in 1..4) {
            flexbox.addView(makeSquareView(i))
        }
    }

    val width = 30f
    val height = 30f
    val margin = 6f

    private fun makeSquareView(number: Int): View {

        val scale = resources.displayMetrics.density
        val minWidth = (width * scale).toInt()
        val minHeight = (height * scale).toInt()
        val margin = (margin * scale).toInt()

        val params = FlexboxLayout.LayoutParams(
                FlexboxLayout.LayoutParams.WRAP_CONTENT,
                FlexboxLayout.LayoutParams.WRAP_CONTENT)
        params.setMargins(0, 0, margin, margin)

        val routeView = TextView(this)
        routeView.layoutParams = params
        routeView.minWidth = minWidth
        routeView.minHeight = minHeight

        routeView.text = number.toString()
        routeView.setBackgroundColor(resources.getColor(R.color.colorPrimary))

        return routeView
    }
}