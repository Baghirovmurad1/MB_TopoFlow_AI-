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
        OPEN_CLOSE("⏏", 0x9A),
        FUNCTION("FUNCTION", 0x8A),
        OPTICAL("OPTICAL", 0xB6),
        SLEEP("SLEEP", 0xC2),
        SOUND_EFFECT("SOUND\nEFFECT", 0x2F),
        SPEAKER_LEVEL("SPEAKER\nLEVEL", 0x66),

        N1("1", 0x41), N2("2", 0x42), N3("3", 0x43),
        N4("4", 0x44), N5("5", 0x45), N6("6", 0x46),
        N7("7", 0x47), N8("8", 0x48), N9("9", 0x49),
        N0("0", 0x4B),
        CLEAR("CLEAR", 0xB0),
        REPEAT("REPEAT", 0x4E),

        HOME("HOME", 0xA5),
        INFO("INFO", 0xA3),
        DISC_MENU("DISC\nMENU", 0xA4),
        TITLE_POPUP("TITLE/\nPOPUP", 0xAF),

        UP("▲", 0xA7, repeat = true),
        DOWN("▼", 0xA6, repeat = true),
        LEFT("◀", 0xA8, repeat = true),
        RIGHT("▶", 0xA9, repeat = true),
        ENTER("OK", 0xAA),
        BACK("BACK", 0xA2),

        PREV("⏮", 0x06),
        REW("⏪", 0x53),
        FF("⏩", 0x52),
        NEXT("⏭", 0x07),
        STOP("⏹", 0x05),
        PLAY("▶", 0x04),
        PAUSE("⏸", 0x4F),

        VOL_DOWN("VOL −", 0x16, repeat = true),
        MUTE("MUTE", 0x1F),
        VOL_UP("VOL +", 0x17, repeat = true),

        RED("", 0x6C), GREEN("", 0x6D), YELLOW("", 0x6E), BLUE("", 0x6F),

        AUDIO("AUDIO", 0x36),
        SUBTITLE("SUBTITLE", 0xAB),
        REC("● REC", 0x83);

        val pattern: IntArray by lazy { Samsung32.encode(ADDRESS, command) }
    }
}
