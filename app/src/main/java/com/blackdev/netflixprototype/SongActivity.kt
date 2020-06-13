package com.blackdev.netflixprototype

import android.content.Context
import android.content.Intent
import android.media.AudioDeviceCallback
import android.media.AudioDeviceInfo
import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.lottie.LottieAnimationView
import kotlin.math.floor


class SongActivity : AppCompatActivity() {



    var songID: Int = -1
    var imageID: Int = -1
    var title :String = ""
    lateinit var progress: SeekBar
     var musicPlayer: MediaPlayer = MediaPlayer()
    var playPauseCheck:Boolean = false
    val seekHandler: Handler = Handler()
    lateinit var currDuration: TextView
    lateinit var totalDuration: TextView
    var min:Int = 0
    var second:Int = 0
    lateinit var layout:ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song)
        title = intent.getStringExtra("title")
        songID = intent.getIntExtra("songID",-1)
        imageID = intent.getIntExtra("imageID",-1)
        currDuration = findViewById(R.id.currentPosition)

        totalDuration = findViewById(R.id.duration)

        layout = findViewById<ConstraintLayout>(R.id.layout)
        layout.setOnTouchListener(SwipeListener(this))
        val name = findViewById<TextView>(R.id.songTitle)
        val image = findViewById<ImageView>(R.id.songImage)
        progress = findViewById(R.id.progress_bar)
              name.setText(title)
        image.setImageResource(imageID)

        musicPlayer = MediaPlayer.create(this,songID)

        val lottie = findViewById<LottieAnimationView>(R.id.lottiePlay)


        progress.setProgress(musicPlayer.currentPosition)
        if (musicPlayer.isPlaying)
            lottie.setMinAndMaxFrame(35, 67)
        time()
        val totalmin = musicPlayer.duration/(1000*60)
        val totalsec = musicPlayer.duration/1000 - totalmin*60
        if(totalmin<10){
            if(totalsec<10) {
                totalDuration.setText("0" + totalmin + ":" +"0"+totalsec)
            }else{
                totalDuration.setText("0" + totalmin + ":" + totalsec)

            }
        }else{
            if(totalsec<10) {
                totalDuration.setText( ""+ totalmin + ":" +"0"+totalsec)
            }else{
                totalDuration.setText( ""+totalmin + ":" + totalsec)

            }
        }
        progress.max = musicPlayer.duration
        checkProgress()
        updateSeek()






    }



    fun time(){
        min =musicPlayer.currentPosition/(1000*60)
        second = musicPlayer.currentPosition/1000 -min*60
        if( musicPlayer.duration/(1000*60)<10){
            if(second < 10) {
                currDuration.setText("0" + min + ":" +"0"+second)
            }else{
                currDuration.setText("0" + min + ":" +second)
            }
        }
        else{
            if(second < 10) {
                currDuration.setText(""+min + ":" +"0"+second)
            }else{
                currDuration.setText(""+min + ":" +second)
            }
        }

    }

    val runnable = Runnable(){
        updateSeek()
    }
fun updateSeek(){
    time()

        progress.setProgress(musicPlayer.currentPosition)
    seekHandler.postDelayed(runnable, 1000)


}
    fun checkProgress(){
        progress.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                if(fromUser){
                    musicPlayer.seekTo(progress)
                    time()
                    Log.i("user","true")
                    seekHandler.postDelayed(runnable, 1000)


                }
               // Write code to perform some action when progress is changed.
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {


                // Write code to perform some action when touch is started.
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Write code to perform some action when touch is stopped.

            }
        })



    }

    fun playpausebutton(view:View){




        val lottie = findViewById<LottieAnimationView>(R.id.lottiePlay)
        if (!playPauseCheck) {

            playPauseCheck = true
            lottie.setMinAndMaxFrame(0, 34)
            lottie.playAnimation()
            musicPlayer.start()
            lottie.repeatCount = 0


        } else {

            playPauseCheck = false
            lottie.setMinAndMaxFrame(35, 67)
            lottie.playAnimation()
            musicPlayer.pause()
            lottie.repeatCount = 0


        }




    }
    fun resetFun(view:View){

        musicPlayer.seekTo(0)
        checkProgress()

        val reset = findViewById<LottieAnimationView>(R.id.lottieReplay)
        reset.playAnimation()
        reset.repeatCount = 0


    }

    override fun onPause() {
        super.onPause()
        musicPlayer.stop()

        finish()
    }








}

