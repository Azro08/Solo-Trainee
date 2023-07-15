package com.example.lifecycleapp

import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue


class MainActivity : ComponentActivity() {
    private var counter by mutableStateOf(0)
    private var currentScreen by mutableStateOf(ScreenState.Counter)
    private val COUNTER_VALUE = "labelValue"
    private var timeInBackground: Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(COUNTER_VALUE, 0)
        }
        setContent {
            MyApp {
                when (val screen = currentScreen) {
                    ScreenState.Counter -> CounterScreen(
                        counter = counter,
                        onButtonClicked = { currentScreen = ScreenState.UpdateCounter }
                    )

                    ScreenState.UpdateCounter -> UpdateCounterScreen(
                        onCancel = { currentScreen = ScreenState.Counter },
                        onUpdate = {
                            counter += 10
                            currentScreen = ScreenState.Counter
                        }
                    )
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        counter += 2

        if (timeInBackground > 0) {
            val elapsedTime = SystemClock.elapsedRealtime() - timeInBackground
            val minutesInBackground = (elapsedTime / (1000 * 60)).toInt()
            counter -= (2 * minutesInBackground)
            timeInBackground = 0
        }
        Log.d("current callback method", "onResume, time in bgnd: $timeInBackground, counter: $counter")
    }

    override fun onPause() {
        super.onPause()
        counter += 5
        timeInBackground = SystemClock.elapsedRealtime()
        Log.d("current callback method", "onPause, time in bgnd: $timeInBackground, counter: $counter")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(COUNTER_VALUE, counter)
    }

}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    MaterialTheme {
        content()
    }
}