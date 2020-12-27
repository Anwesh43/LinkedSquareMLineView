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

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.sinify() : Float = Math.sin(this * Math.PI).toFloat()

fun Canvas.drawSquareMLine(scale : Float, w : Float, h : Float, paint : Paint) {
    val size : Float = Math.min(w, h) / sizeFactor
    val mSize : Float = Math.min(w, h) / mSizeFactor
    val sf : Float = scale.sinify()
    val sf1 : Float = sf.divideScale(0, parts)
    val sf2 : Float = sf.divideScale(1, parts)
    val sf3 : Float = sf.divideScale(2, parts)
    save()
    translate(w / 2, h)
    drawRect(RectF(-mSize, -mSize * sf1 * 0.5f, mSize, 0f), paint)
    for (j in 0..1) {
        save()
        scale(1f - 2 * j, 1f)
        drawLine(-mSize, -mSize / 2, -mSize - size * sf2, -mSize / 2 - size * sf2, paint)
        drawLine(-mSize - size, 0f, -mSize - size, -size * sf3, paint)
        restore()
    }
    restore()
}

fun Canvas.drawSMLNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    paint.color = colors[i]
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    drawSquareMLine(scale, w, h, paint)
}