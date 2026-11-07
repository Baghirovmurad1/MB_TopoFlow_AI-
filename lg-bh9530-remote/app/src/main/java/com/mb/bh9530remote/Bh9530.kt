package com.mb.bh9530remote

/**
 * ИК-коды домашнего кинотеатра LG BH9530 (протокол Samsung32, адрес 0x2C).
 *
 * Источник: Flipper-IRDB, пульты LG BH9520TW, LHB655 и AKB73775801 —
 * кинотеатры LG той же линейки с одинаковой системой команд. Коды громкости,
 * питания и входа совпадают и с базой IRDB (LG, device 44 = 0x2C).
 */
object Bh9530 {
    const val ADDRESS = 0x2C

    enum class Key(val label: String, val command: Int, val repeat: Boolean = false) {
        POWER("POWER", 0x1E),
        FUNCTION("FUNCTION", 0x8A),
        SOUND_EFFECT("SOUND\nEFFECT", 0x2F),
        SPEAKER_LEVEL("SPEAKER\nLEVEL", 0x66),
        VOL_DOWN("−", 0x16, repeat = true),
        MUTE("MUTE", 0x1F),
        VOL_UP("+", 0x17, repeat = true);

        val pattern: IntArray by lazy { Samsung32.encode(ADDRESS, command) }
    }
}
