package com.mb.bh9530remote

/**
 * Кодировщик ИК-протокола Samsung32 (его использует аудиотехника LG, в т.ч. BH9530).
 *
 * Кадр: заголовок 4500 мкс импульс + 4500 мкс пауза, затем 32 бита
 * (адрес, адрес, команда, инвертированная команда; каждый байт младшим битом вперёд),
 * затем стоп-импульс 560 мкс. Бит: импульс 560 мкс + пауза 560 (0) или 1690 (1) мкс.
 */
object Samsung32 {
    const val CARRIER_HZ = 38_000

    private const val HEADER_MARK = 4500
    private const val HEADER_SPACE = 4500
    private const val BIT_MARK = 560
    private const val ZERO_SPACE = 560
    private const val ONE_SPACE = 1690

    /** Возвращает шаблон в микросекундах для ConsumerIrManager.transmit (вкл/выкл по очереди). */
    fun encode(address: Int, command: Int): IntArray {
        val bytes = intArrayOf(address and 0xFF, address and 0xFF, command and 0xFF, command.inv() and 0xFF)
        val pattern = ArrayList<Int>(2 + 64 + 1)
        pattern += HEADER_MARK
        pattern += HEADER_SPACE
        for (b in bytes) {
            for (i in 0 until 8) {
                pattern += BIT_MARK
                pattern += if ((b shr i) and 1 == 1) ONE_SPACE else ZERO_SPACE
            }
        }
        pattern += BIT_MARK
        return pattern.toIntArray()
    }
}
