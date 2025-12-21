package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {

    // ТЕСТЫ ГРОМКОСТИ:

    @Test
    void shouldGetInitialVolume() {
        Radio radio = new Radio();
        assertEquals(0, radio.getCurrentVolume());
    }
    // Проверяем, что начальная громкость всегда 0.

    @Test
    void shouldIncreaseVolumeByOne() {
        Radio radio = new Radio();
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());
    }
    // Проверяем, что увеличение громкости работает корректно: +1 от текущего значения.

    @Test
    void shouldNotExceedMaxVolume100() {
        Radio radio = new Radio();
        for (int i = 0; i < 150; i++) {
            radio.increaseVolume();
        }
        assertEquals(100, radio.getCurrentVolume());
    }
    // Проверяем, что громкость не превышает 100, даже если нажимать + много раз.

    @Test
    void shouldDecreaseVolumeByOne() {
        Radio radio = new Radio();
        radio.increaseVolume();
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }
    // Проверяем, что уменьшение громкости работает корректно: -1 от текущего значения.

    @Test
    void shouldNotGoBelowMinVolume0() {
        Radio radio = new Radio();
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }
    // Проверяем, что громкость не уходит ниже 0.


    // ТЕСТЫ СТАНЦИЙ:

    @Test
    void shouldGetInitialStation() {
        Radio radio = new Radio();
        assertEquals(0, radio.getCurrentStation());
    }
    // Проверяем, что начальная станция всегда 0.

    @Test
    void shouldSetValidStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }
    // Проверяем, что корректное значение станции устанавливается.

    @Test
    void shouldIgnoreInvalidStationBelowRange() {
        Radio radio = new Radio();
        radio.setCurrentStation(3);
        radio.setCurrentStation(-1);
        assertEquals(3, radio.getCurrentStation());
    }
    // Если попытаться установить станцию ниже 0, значение должно игнорироваться.

    @Test
    void shouldIgnoreInvalidStationAboveRange() {
        Radio radio = new Radio();
        radio.setCurrentStation(7);
        radio.setCurrentStation(10);
        assertEquals(7, radio.getCurrentStation());
    }
    // Если попытаться установить станцию выше максимальной (9 при 10 станциях), значение игнорируется.


    // --- ТЕСТЫ ПЕРЕКЛЮЧЕНИЯ СТАНЦИЙ (ГИБКОЕ КОЛИЧЕСТВО) ---

    @Test
    void shouldGoNextInMiddleRange() {
        Radio radio = new Radio(15); // 15 станций: 0–14
        radio.setCurrentStation(4);
        radio.next();
        assertEquals(5, radio.getCurrentStation());
    }
    // Проверяем обычное переключение вперёд внутри диапазона.

    @Test
    void shouldWrapNextFromLastToZero() {
        Radio radio = new Radio(15);
        int last = radio.getStationsCount() - 1; // 14
        radio.setCurrentStation(last);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }
    // Если текущая станция последняя, next должен переключать на 0.

    @Test
    void shouldGoPrevInMiddleRange() {
        Radio radio = new Radio(20);
        radio.setCurrentStation(6);
        radio.prev();
        assertEquals(5, radio.getCurrentStation());
    }
    // Проверяем обычное переключение назад внутри диапазона.

    @Test
    void shouldWrapPrevFromZeroToLast() {
        Radio radio = new Radio(20);
        int last = radio.getStationsCount() - 1; // 19
        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(last, radio.getCurrentStation());
    }
    // Если текущая станция 0, prev должен переключать на последнюю станцию.


    // ТЕСТЫ КОЛИЧЕСТВА СТАНЦИЙ:

    @Test
    void shouldSetDefaultStationsCount() {
        Radio radio = new Radio();
        assertEquals(10, radio.getStationsCount());
    }
    // Проверяем, что по умолчанию количество станций = 10.

    @Test
    void shouldSetCustomStationsCount() {
        Radio radio = new Radio(30);
        assertEquals(30, radio.getStationsCount());
    }
    // Проверяем, что конструктор с параметром корректно задаёт количество станций.
}