package com.example.chronometerapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

class MainActivity : ComponentActivity() {
    private var sessionDuration by mutableStateOf(0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChronometerApp()
        }
        startThreads()
    }

    private fun startThreads() {
        Thread {
            while (true) {
                Thread.sleep(1000)
                sessionDuration++
            }
        }.start()

        Thread {
            var toastCount = 0
            while (true) {
                Thread.sleep(10000)
                toastCount ++
                Log.d("thread_toast_counter", "first thread : $toastCount")
                if (toastCount % 4 != 0)
                {
                    showToast("Session Duration: $sessionDuration seconds")
                }
            }
        }.start()

        Thread {
            var toastCount = 0
            while (true) {
                Thread.sleep(10000)
                toastCount++
                Log.d("thread_toast_counter", "second thread : $toastCount")
                if (toastCount % 4 == 0) {
                    showToast("Surprise!")
                }
            }
        }.start()
    }

    private fun showToast(message: String) {
        runOnUiThread{
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }

    @Composable
    fun ChronometerApp() {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Session duration: $sessionDuration secs"
            )
        }
    }
}
