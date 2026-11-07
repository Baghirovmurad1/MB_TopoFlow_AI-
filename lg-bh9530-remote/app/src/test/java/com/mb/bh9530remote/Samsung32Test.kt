package com.mb.bh9530remote

import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Test

class Samsung32Test {

    /** Восстанавливает 32 бита из шаблона (LSB вперёд), чтобы сверить с кодом. */
    private fun decode(p: IntArray): Long {
        var v = 0L
        for (i in 0 until 32) if (p[3 + i * 2] > 1000) v = v or (1L shl i)
        return v
    }

    @Test
    fun powerFrameMatchesLgCode() {
        val p = Samsung32.encode(0x2C, 0x1E)
        assertEquals(67, p.size)
        assertArrayEquals(intArrayOf(4500, 4500), p.copyOfRange(0, 2))
        assertEquals(560, p.last())
        // Байты по порядку: 2C 2C 1E E1 -> как 32-битное число LSB-first: 0xE11E2C2C
        assertEquals(0xE11E2C2CL, decode(p))
    }

    @Test
    fun everyKeyHasValidFrame() {
        for (k in Bh9530.Key.values()) {
            val v = decode(k.pattern)
            assertEquals(k.name, 0x2C2CL, v and 0xFFFF)
            assertEquals(k.name, k.command.toLong(), (v shr 16) and 0xFF)
            assertEquals(k.name, (k.command.inv() and 0xFF).toLong(), (v shr 24) and 0xFF)
            // Кадр должен уложиться в период повтора 110 мс.
            assertEquals(true, k.pattern.sum() < 110_000)
        }
    }

    @Test
    fun commandsAreUnique() {
        val cmds = Bh9530.Key.values().map { it.command }
        assertEquals(cmds.size, cmds.toSet().size)
    }
}
