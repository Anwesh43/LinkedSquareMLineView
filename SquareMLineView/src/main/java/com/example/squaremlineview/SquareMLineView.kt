package com.example.squaremlineview

import android.view.View
import android.view.MotionEvent
import android.app.Activity
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.RectF

val parts : Int = 3
val scGap : Float = 0.02f / parts
val strokeFactor : Float = 90f
val sizeFactor : Float = 4.9f
val delay : Long = 20
val backColor : Int = Color.parseColor("#BDBDBD")
val mSizeFactor : Float = 8.9f
val colors : Array<Int> = arrayOf(
    "#F44336",
    "#3F51B5",
    "#8BC34A",
    "#009688",
    "#795548"
).map {
    Color.parseColor(it)
}.toTypedArray()

