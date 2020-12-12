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

    private fun makeColored(view: View, list :List<(View)->Unit>){

        //println({view.setBackgroundColor(Color.GRAY)}.javaClass)
        //println({view.setBackgroundResource(R.drawable.ic_baseline_arrow_right_alt_24)}.javaClass)
//        when (view.id){
//            R.id.box_one_text -> {
//
//                list.random().invoke(view)}
//            R.id.box_two_text -> {
//
//                list.random().invoke(view)}
//            R.id.box_three_text -> {
//
//                list.random().invoke(view)}
//            R.id.box_four_text -> {
//                list.random().invoke(view)}
//            R.id.box_five_text -> { list.random().invoke(view)}
//            else -> view.setBackgroundColor(Color.LTGRAY)
//        }
        list.random().invoke(view)
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

        val listOfListOfFunctions : List<List<(View)->Unit>> = listOf(listOf<(View) -> Unit>({ it.setBackgroundResource(R.drawable.ic_baseline_accessible_forward_24) },
            {it.setBackgroundColor(Color.YELLOW)},{ it.setBackgroundColor(Color.DKGRAY) }), listOf<(View)->Unit>({it.setBackgroundColor(Color.BLUE)}, {it.setBackgroundColor(Color.BLACK)},
            {it.setBackgroundResource(R.drawable.ic_baseline_add_reaction_24)}), listOf<(View)->Unit>( {it.setBackgroundColor(Color.GRAY)}, {it.setBackgroundColor(Color.CYAN)},
            {it.setBackgroundResource(R.drawable.ic_baseline_adb_24)}  ), listOf<(View)->Unit>({it.setBackgroundColor(Color.MAGENTA)},
            {it.setBackgroundColor(Color.GREEN)}, {it.setBackgroundResource(R.drawable.ic_baseline_speaker_24)}), listOf({it.setBackgroundColor(Color.BLUE)}, {it.setBackgroundColor(Color.RED)},
            {it.setBackgroundResource(R.drawable.ic_baseline_arrow_right_alt_24)}), listOf({it.setBackgroundColor(Color.LTGRAY)}, {it.setBackgroundColor(Color.CYAN)}))

        for ((i, view) in clickableViews.withIndex()){

            view.setOnClickListener{makeColored(view, listOfListOfFunctions[i])}
        }

    }
}