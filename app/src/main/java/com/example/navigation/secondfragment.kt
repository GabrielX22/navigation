package com.example.navigation

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_secondfragment.*


class secondfragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_secondfragment, container, false)
    }
    private lateinit var mediaPlayer:MediaPlayer
    var pause:Boolean = false
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        imagepause.visibility = View.GONE
        imageplay.setOnClickListener {
            if(pause){
                mediaPlayer?.start()
                imagepause.visibility = View.VISIBLE
                imageplay.visibility = View.GONE
                pause = false
            }
            else{
                mediaPlayer = MediaPlayer.create(this.context,R.raw.himnougb)
                mediaPlayer?.start()
                imagepause.visibility = View.VISIBLE
                imageplay.visibility = View.GONE
            }

        }

        imagepause.setOnClickListener {
            if (mediaPlayer!!.isPlaying){
                mediaPlayer?.pause()
                imagepause.visibility = View.GONE
                imageplay.visibility = View.VISIBLE
                pause = true
            }
        }
        imagestop.setOnClickListener {
            if (mediaPlayer!!.isPlaying || pause.equals(true)){
                pause=false
                imagepause.visibility = View.GONE
                imageplay.visibility = View.VISIBLE
                mediaPlayer?.stop()
                mediaPlayer?.reset()
                mediaPlayer?.release()
            }
        }
    }
}