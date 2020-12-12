package com.aaqanddev.colormyviews

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    private fun makeColored(view: View){

        println({view.setBackgroundColor(Color.GRAY)}.javaClass)
        println({view.setBackgroundResource(R.drawable.ic_baseline_arrow_right_alt_24)}.javaClass)
        when (view.id){
            R.id.box_one_text -> { val oneFunList =
                listOf<()->Unit>({ view.setBackgroundResource(R.drawable.ic_baseline_accessible_forward_24) },
                    {view.setBackgroundColor(Color.YELLOW)},{ view.setBackgroundColor(Color.DKGRAY) });
                oneFunList.random().invoke()}
            R.id.box_two_text -> { val twoFunList =
                listOf({view.setBackgroundColor(Color.GRAY)}, {view.setBackgroundColor(Color.CYAN)},
                    {view.setBackgroundResource(R.drawable.ic_baseline_adb_24)});
                twoFunList.random().invoke()}
            R.id.box_three_text -> { val threeFunList =
                listOf({view.setBackgroundColor(Color.BLUE)}, {view.setBackgroundColor(Color.BLACK)},
                    {view.setBackgroundResource(R.drawable.ic_baseline_add_reaction_24)});
                threeFunList.random().invoke()}
            R.id.box_four_text -> {val fourFunList = listOf({view.setBackgroundColor(Color.MAGENTA)},
                {view.setBackgroundColor(Color.GREEN)}, {view.setBackgroundResource(R.drawable.ic_baseline_speaker_24)});
                fourFunList.random().invoke()}
            R.id.box_five_text -> { listOf({view.setBackgroundColor(Color.BLUE)}, {view.setBackgroundColor(Color.RED)},
                {view.setBackgroundResource(R.drawable.ic_baseline_arrow_right_alt_24)}).random().invoke()}
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

    private fun setListeners(){
        val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoTextView: TextView = findViewById(R.id.box_two_text)
        val boxThreeTextView : TextView = findViewById(R.id.box_three_text)
        val boxFourTextView: TextView = findViewById(R.id.box_four_text)
        val boxFiveTextView : TextView = findViewById(R.id.box_five_text)
        val rootConstraintLayout: View = findViewById(R.id.constraint_layout)

        val clickableViews: List<View> =
            listOf(boxOneText, boxTwoTextView, boxThreeTextView, boxFourTextView,
                boxFiveTextView, rootConstraintLayout)

        for (view in clickableViews){
            view.setOnClickListener{makeColored(view)}
        }
    }
}