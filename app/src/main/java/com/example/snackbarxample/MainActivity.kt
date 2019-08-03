package com.example.snackbarxample

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    var coordinatorLayout: CoordinatorLayout? = null
    private var one: Button? = null
    private var two: Button? = null
    private var three: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        coordinatorLayout = findViewById(R.id.coordinatorLayout) as CoordinatorLayout
        one = findViewById(R.id.button) as Button
        two = findViewById(R.id.button2) as Button
        three = findViewById(R.id.button3) as Button
        one!!.setOnClickListener(object : View.OnClickListener {
           override fun onClick(v: View) {
                val snackbar = Snackbar
                        .make(coordinatorLayout!!, "Snackbar Tutorial", Snackbar.LENGTH_LONG)
                snackbar.show()
            }
        })

        two!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val snackbar = Snackbar
                        .make(coordinatorLayout!!, "ACTION CALL SNACKBAR with Undo Button", Snackbar.LENGTH_LONG)
                        .setAction("UNDO", object : View.OnClickListener {
                           override fun onClick(view: View) {
                                val snackbar1 = Snackbar.make(coordinatorLayout!!, "Message is restored!", Snackbar.LENGTH_SHORT)
                                snackbar1.show()
                            }
                        })

                snackbar.show()
            }

        })

        three!!.setOnClickListener(object : View.OnClickListener {
            override  fun onClick(v: View) {
                val snackbar = Snackbar
                        .make(coordinatorLayout!!, "CUSTOM VIEW SNACKBAR", Snackbar.LENGTH_LONG)
                        .setAction("RETRY", object : View.OnClickListener {
                          override  fun onClick(view: View) {}
                        })
                snackbar.setActionTextColor(Color.RED)
                val sbView = snackbar.getView()
                val textView = sbView.findViewById(R.id.snackbar_text) as TextView
                textView.setTextColor(Color.YELLOW)
                snackbar.show()
            }
        })
    }
}
