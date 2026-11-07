# Пульт LG BH9530 для Android

Приложение превращает телефон с ИК-передатчиком (Xiaomi/Redmi/POCO, Huawei/Honor,
часть старых Samsung/LG и т.п.) в пульт для домашнего кинотеатра **LG BH9530 (BH9530TW)** —
3D Blu-ray системы 9.1 с проигрывателем, тюнером и USB.

## Как это работает

- Отправка идёт через стандартный Android API `ConsumerIrManager` (разрешение `TRANSMIT_IR`,
  интернет и Bluetooth не нужны).
- Аудиотехника LG использует ИК-протокол **Samsung32**: несущая 38 кГц, заголовок 4,5 мс + 4,5 мс,
  32 бита: адрес `0x2C`, адрес `0x2C`, команда, инверсия команды. Кодировщик — `Samsung32.kt`.
- VOL+/VOL− можно удерживать — кадр повторяется каждые 110 мс, как у штатного пульта.

## Кнопки в приложении

POWER, FUNCTION (выбор входа), SOUND EFFECT, SPEAKER LEVEL, VOL −, MUTE, VOL +.

## Коды всех кнопок штатного пульта (адрес 0x2C)

Таблица — справочник: если понадобится вернуть кнопку, добавьте её код в `Bh9530.kt`.

| Кнопка | Код | Кнопка | Код | Кнопка | Код |
|---|---|---|---|---|---|
| POWER | 1E | HOME | A5 | VOL + | 17 |
| OPEN/CLOSE | 9A | INFO | A3 | VOL − | 16 |
| FUNCTION (вход) | 8A | DISC MENU | A4 | MUTE | 1F |
| OPTICAL / TV sound | B6 | TITLE/POPUP | AF | ▶ PLAY | 04 |
| SLEEP | C2 | ▲ ▼ ◀ ▶ | A7 A6 A8 A9 | ⏸ PAUSE | 4F |
| SOUND EFFECT | 2F | OK (ENTER) | AA | ⏹ STOP | 05 |
| SPEAKER LEVEL | 66 | BACK | A2 | ⏮ / ⏭ (и PRESET −/+) | 06 / 07 |
| 1…9 | 41…49 | AUDIO | 36 | ⏪ / ⏩ | 53 / 52 |
| 0 | 4B | SUBTITLE | AB | Красная/Зелёная/Жёлтая/Синяя | 6C/6D/6E/6F |
| CLEAR | B0 | REPEAT | 4E | ● REC (запись на USB) | 83 |

**Откуда коды.** Отдельной базы именно для BH9530 в открытом доступе нет. Коды взяты из
[Flipper-IRDB](https://github.com/Lucaslhm/Flipper-IRDB/tree/main/Blu-Ray/LG): пульты
**LG BH9520TW** (прямой предшественник BH9530TW), LHB655 и AKB73775801. У всех трёх
одинаковые коды, а питание, громкость, вход, SOUND EFFECT, OPTICAL и SLEEP дополнительно
совпадают с базой [IRDB](https://github.com/probonopd/irdb) (LG, device 44 = 0x2C).
Кнопки управления телевизором со штатного пульта сюда не включены.

Если какая-то кнопка не срабатывает, её код можно поправить в `Bh9530.kt`.

## Сборка

Нужны JDK 17+ и Android SDK (platform 35).

```bash
echo "sdk.dir=/путь/к/android-sdk" > local.properties
./gradlew testDebugUnitTest assembleRelease
# APK: app/build/outputs/apk/release/app-release.apk
```

Release-сборка подписана debug-ключом, поэтому APK можно сразу установить на телефон
(разрешите установку из неизвестных источников). Можно и просто открыть папку в Android Studio.

## Установка и проверка

1. Установите APK на телефон с ИК-портом. Если ИК-порта нет, приложение покажет об этом сообщение.
2. Направьте верхний торец телефона на кинотеатр с расстояния 1–3 м.
3. Нажмите POWER, затем VOL+/VOL− — на дисплее кинотеатра должна меняться громкость.
