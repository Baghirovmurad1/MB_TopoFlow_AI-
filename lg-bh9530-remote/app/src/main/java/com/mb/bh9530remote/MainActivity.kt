package com.mb.bh9530remote

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.RippleDrawable
import android.hardware.ConsumerIrManager
import android.os.Bundle
import android.view.Gravity
import android.view.HapticFeedbackConstants
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
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
    private val volumeViews = HashMap<Key, View>()

    private val bgTop = Color.rgb(30, 32, 44)
    private val bgBottom = Color.rgb(10, 11, 16)
    private val card = Color.rgb(38, 41, 56)
    private val cardStroke = Color.rgb(56, 60, 80)
    private val accent = Color.rgb(140, 160, 255)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ir = (getSystemService(Context.CONSUMER_IR_SERVICE) as? ConsumerIrManager)
            ?.takeIf { it.hasIrEmitter() }
        window.statusBarColor = bgTop
        window.navigationBarColor = bgBottom

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_HORIZONTAL
            fitsSystemWindows = true
            setPadding(dp(24), dp(24), dp(24), dp(24))
            background = GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(bgTop, bgBottom))
        }

        root.addView(space())
        root.addView(powerButton(), LinearLayout.LayoutParams(dp(128), dp(128)))
        root.addView(space())

        val modes = LinearLayout(this).apply { orientation = LinearLayout.HORIZONTAL; isBaselineAligned = false }
        for (key in listOf(Key.FUNCTION, Key.SOUND_EFFECT, Key.SPEAKER_LEVEL)) {
            modes.addView(
                keyView(key, key.label, 13f, roundRect(card, dp(22))).apply { letterSpacing = 0.08f },
                LinearLayout.LayoutParams(0, dp(104), 1f).apply { setMargins(dp(6), 0, dp(6), 0) },
            )
        }
        root.addView(modes, matchWidth())
        root.addView(space())

        root.addView(caption("VOLUME"), matchWidth())
        root.addView(volumeBar(), matchWidth(dp(84)))
        root.addView(space())

        setContentView(root)
    }

    /** Боковые кнопки громкости телефона управляют громкостью кинотеатра. */
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        val key = sideKey(keyCode) ?: return super.onKeyDown(keyCode, event)
        if (event.repeatCount == 0) {
            volumeViews[key]?.isPressed = true
            startRepeat(key)
        }
        return true
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent): Boolean {
        val key = sideKey(keyCode) ?: return super.onKeyUp(keyCode, event)
        volumeViews[key]?.isPressed = false
        stopRepeat()
        return true
    }

    private fun sideKey(keyCode: Int): Key? = when (keyCode) {
        KeyEvent.KEYCODE_VOLUME_UP -> Key.VOL_UP
        KeyEvent.KEYCODE_VOLUME_DOWN -> Key.VOL_DOWN
        else -> null
    }

    override fun onPause() {
        stopRepeat()
        volumeViews.values.forEach { it.isPressed = false }
        super.onPause()
    }

    override fun onDestroy() {
        sender.shutdownNow()
        super.onDestroy()
    }

    private fun powerButton(): View = ImageButton(this).apply {
        setImageResource(R.drawable.ic_power)
        contentDescription = Key.POWER.name
        elevation = dp(10).toFloat()
        val shape = GradientDrawable(
            GradientDrawable.Orientation.TL_BR,
            intArrayOf(Color.rgb(255, 92, 108), Color.rgb(196, 28, 52)),
        ).apply { shape = GradientDrawable.OVAL }
        background = ripple(shape)
        bindKey(this, Key.POWER)
    }

    /** Одна «таблетка»: − | MUTE | +. */
    private fun volumeBar(): View {
        val bar = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            background = roundRect(card, dp(42))
            clipToOutline = true
            elevation = dp(4).toFloat()
        }
        val segment = { key: Key, size: Float -> keyView(key, key.label, size, null).also { volumeViews[key] = it } }
        bar.addView(segment(Key.VOL_DOWN, 34f), LinearLayout.LayoutParams(0, -1, 1f))
        bar.addView(divider(), LinearLayout.LayoutParams(dp(1), -1).apply { setMargins(0, dp(18), 0, dp(18)) })
        bar.addView(segment(Key.MUTE, 13f).apply { setTextColor(accent); letterSpacing = 0.12f }, LinearLayout.LayoutParams(0, -1, 1f))
        bar.addView(divider(), LinearLayout.LayoutParams(dp(1), -1).apply { setMargins(0, dp(18), 0, dp(18)) })
        bar.addView(segment(Key.VOL_UP, 34f), LinearLayout.LayoutParams(0, -1, 1f))
        return bar
    }

    private fun keyView(key: Key, label: String, size: Float, shape: GradientDrawable?): TextView =
        TextView(this).apply {
            text = label
            contentDescription = key.name
            gravity = Gravity.CENTER
            textSize = size
            typeface = Typeface.create("sans-serif-medium", Typeface.NORMAL)
            setTextColor(Color.WHITE)
            isClickable = true
            background = if (shape != null) {
                elevation = dp(4).toFloat()
                ripple(shape)
            } else {
                RippleDrawable(ColorStateList.valueOf(0x33FFFFFF), null, null)
            }
            bindKey(this, key)
        }

    @SuppressLint("ClickableViewAccessibility")
    private fun bindKey(view: View, key: Key) {
        if (key.repeat) {
            // Удержание: повторяем кадр каждые 110 мс, как штатный пульт.
            view.setOnTouchListener { v, e ->
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
            view.setOnClickListener {
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

    private fun roundRect(color: Int, radius: Int) = GradientDrawable().apply {
        cornerRadius = radius.toFloat()
        setColor(color)
        setStroke(dp(1), cardStroke)
    }

    private fun ripple(content: Drawable) = RippleDrawable(ColorStateList.valueOf(0x40FFFFFF), content, null)

    private fun caption(text: String) = TextView(this).apply {
        this.text = text
        textSize = 11f
        letterSpacing = 0.3f
        gravity = Gravity.CENTER
        setTextColor(Color.rgb(120, 126, 150))
        setPadding(0, 0, 0, dp(10))
    }

    private fun divider() = View(this).apply { setBackgroundColor(cardStroke) }

    private fun space() = View(this).apply { layoutParams = LinearLayout.LayoutParams(1, 0, 1f) }

    private fun matchWidth(height: Int = LinearLayout.LayoutParams.WRAP_CONTENT) =
        LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, height)

    private fun dp(v: Int): Int = (v * resources.displayMetrics.density).toInt()
}
