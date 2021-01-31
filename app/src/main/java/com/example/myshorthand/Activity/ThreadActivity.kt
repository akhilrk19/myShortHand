package com.example.myshorthand.Activity

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myshorthand.R
import kotlinx.android.synthetic.main.activity_second.*

//Threading
class ThreadActivity : AppCompatActivity(), View.OnClickListener {
    var isLooped = false;
    var isSecondLooped = false
    var incrementer = 0;
    var incrementer2 = 100
    var handlerThread: Handler? = null;
    var handlerThread2: Handler? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        start_thread.setOnClickListener(this)
        stop_thread.setOnClickListener(this)
        handlerThread =
            Handler(applicationContext.mainLooper) // applicationContext.mainLooper - UI thread looper
        handlerThread2 = Handler(applicationContext.mainLooper)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.start_thread -> {
                print("This is enter")
                isLooped = true;
                isSecondLooped = true
                Thread({
                    while (isLooped) {
                        Thread.sleep(100)
                        if (incrementer > 100) {
                            incrementer = 0
                        } else
                            incrementer++
                        handlerThread?.post({
                            title_shorthand_second.text = incrementer.toString()
                        })
                    }

                }).start()

                Thread({
                    while (isSecondLooped) {
                        Thread.sleep(95)
                        if (incrementer2 < 0) {
                            incrementer2 = 100
                        } else
                            incrementer2--
                        handlerThread2?.post({
                            title_shorthand_second2.text = incrementer2.toString()
                        })
                    }
                }).start()
            }
            R.id.stop_thread -> {
                isLooped = false
                isSecondLooped = false
            }
        }
    }
}