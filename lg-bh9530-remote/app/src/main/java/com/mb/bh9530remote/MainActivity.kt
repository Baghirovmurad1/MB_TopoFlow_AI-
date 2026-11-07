package com.mb.bh9530remote

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.hardware.ConsumerIrManager
import android.os.Bundle
import android.view.Gravity
import android.view.HapticFeedbackConstants
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import com.mb.bh9530remote.Bh9530.Key
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

class MainActivity : Activity() {

    private var ir: ConsumerIrManager? = null
    private val sender = Executors.newSingleThreadScheduledExecutor()
    private var repeating: ScheduledFuture<*>? = null

    /** Раскладка как на штатном пульте; null — пустое место. */
    private val rows: List<List<Key?>> = listOf(
        listOf(Key.POWER, null, Key.OPEN_CLOSE),
        listOf(Key.FUNCTION, Key.OPTICAL, Key.SLEEP),
        listOf(Key.SOUND_EFFECT, Key.SPEAKER_LEVEL, Key.REC),
        listOf(Key.N1, Key.N2, Key.N3),
        listOf(Key.N4, Key.N5, Key.N6),
        listOf(Key.N7, Key.N8, Key.N9),
        listOf(Key.CLEAR, Key.N0, Key.REPEAT),
        listOf(Key.HOME, Key.INFO, Key.DISC_MENU, Key.TITLE_POPUP),
        listOf(null, Key.UP, null),
        listOf(Key.LEFT, Key.ENTER, Key.RIGHT),
        listOf(Key.BACK, Key.DOWN, null),
        listOf(Key.PREV, Key.REW, Key.FF, Key.NEXT),
        listOf(Key.STOP, Key.PLAY, Key.PAUSE),
        listOf(Key.VOL_DOWN, Key.MUTE, Key.VOL_UP),
        listOf(Key.RED, Key.GREEN, Key.YELLOW, Key.BLUE),
        listOf(Key.AUDIO, Key.SUBTITLE),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ir = (getSystemService(Context.CONSUMER_IR_SERVICE) as? ConsumerIrManager)
            ?.takeIf { it.hasIrEmitter() }

        val column = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(16), dp(16), dp(16), dp(16))
        }
        column.addView(TextView(this).apply {
            text = getString(if (ir == null) R.string.no_ir else R.string.hint)
            setTextColor(if (ir == null) Color.rgb(255, 120, 120) else Color.LTGRAY)
            textSize = 14f
            setPadding(0, 0, 0, dp(12))
        })
        for (row in rows) column.addView(buildRow(row))

        setContentView(ScrollView(this).apply {
            setBackgroundColor(Color.rgb(18, 18, 20))
            addView(column)
        })
    }

    override fun onDestroy() {
        sender.shutdownNow()
        super.onDestroy()
    }

    private fun buildRow(keys: List<Key?>): LinearLayout {
        val row = LinearLayout(this).apply { orientation = LinearLayout.HORIZONTAL }
        for (key in keys) {
            val lp = LinearLayout.LayoutParams(0, dp(56), 1f).apply { setMargins(dp(4), dp(4), dp(4), dp(4)) }
            row.addView(if (key == null) View(this) else buildButton(key), lp)
        }
        return row
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun buildButton(key: Key): Button = Button(this).apply {
        text = key.label
        contentDescription = key.name
        isAllCaps = false
        textSize = if (key.label.length <= 2) 22f else 12f
        setTextColor(Color.WHITE)
        setPadding(0, 0, 0, 0)
        background = GradientDrawable().apply {
            cornerRadius = dp(14).toFloat()
            setColor(colorFor(key))
        }
        if (key.repeat) {
            // Удержание: повторяем кадр каждые 110 мс, как штатный пульт.
            setOnTouchListener { v, e ->
                when (e.action) {
                    MotionEvent.ACTION_DOWN -> {
                        v.isPressed = true
                        v.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
                        startRepeat(key)
                    }
                    MotionEvent.ACTION_UP -> { v.isPressed = false; stopRepeat(); v.performClick() }
                    MotionEvent.ACTION_CANCEL -> { v.isPressed = false; stopRepeat() }
                }
                true
            }
        } else {
            setOnClickListener {
                it.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
                sender.execute { transmit(key) }
            }
        }
    }

    private fun startRepeat(key: Key) {
        stopRepeat()
        repeating = sender.scheduleAtFixedRate({ transmit(key) }, 0, 110, TimeUnit.MILLISECONDS)
    }

    private fun stopRepeat() {
        repeating?.cancel(false)
        repeating = null
    }

    private fun transmit(key: Key) {
        val manager = ir
        if (manager == null) {
            runOnUiThread { Toast.makeText(this, R.string.no_ir, Toast.LENGTH_SHORT).show() }
            return
        }
        try {
            manager.transmit(Samsung32.CARRIER_HZ, key.pattern)
        } catch (e: Exception) {
            runOnUiThread { Toast.makeText(this, "Ошибка ИК: ${e.message}", Toast.LENGTH_SHORT).show() }
        }
    }

    private fun colorFor(key: Key): Int = when (key) {
        Key.POWER -> Color.rgb(200, 40, 50)
        Key.RED -> Color.rgb(210, 50, 50)
        Key.GREEN -> Color.rgb(40, 160, 70)
        Key.YELLOW -> Color.rgb(220, 180, 30)
        Key.BLUE -> Color.rgb(40, 90, 210)
        Key.ENTER -> Color.rgb(90, 90, 110)
        else -> Color.rgb(48, 48, 56)
    }

    private fun dp(v: Int): Int = (v * resources.displayMetrics.density).toInt()
}
