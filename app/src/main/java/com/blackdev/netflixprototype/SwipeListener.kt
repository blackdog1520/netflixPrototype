package com.blackdev.netflixprototype

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View

class SwipeListener(val context: Context):View.OnTouchListener {
    var gestureDetector: GestureDetector
        init {
             gestureDetector = GestureDetector(context,GesListener(context))
        }



    class GesListener(val context: Context): GestureDetector.SimpleOnGestureListener() {
        val swipeThreshold: Int = 100
        val velocityThreshold: Int = 100
        override fun onDown(e: MotionEvent?): Boolean {
            return true
        }

        override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
            var Xdiff = e2.getX()- e1.getX()
            var Ydiff = e2.getY()-e1.getY()
            Log.i("swipe",""+Xdiff+" "+velocityX)
            if(Math.abs(Ydiff)<Math.abs(Xdiff)&&Xdiff<0&&Math.abs(Xdiff)>swipeThreshold && Math.abs(velocityX)>velocityThreshold){
                backToMainMenu()
                Log.i("calleed","true")
                return true
            }

            return false

        }

        private fun backToMainMenu() {
            context.startActivity(Intent(context ,MainActivity::class.java))





        }
    }





    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
        return gestureDetector.onTouchEvent(p1)

    }


}