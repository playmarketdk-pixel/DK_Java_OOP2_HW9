package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RadioTest {

    @Test
    void shouldGetInitialVolume() {
        Radio radio = new Radio();
        assertEquals(0, radio.getCurrentVolume());
    } // этим тестом мы проверяем, что начальное значение громкости = 0

    @Test
    void shouldIncreaseVolumeByOne() {
        Radio radio = new Radio();
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());
    } // этим тестом мы проверяем, что если увеличиваем громкость, она прибавляется на 1

    @Test
    void shouldNotExceedMaxVolume100() {
        Radio radio = new Radio();
        for (int i = 0; i < 101; i++) {
            radio.increaseVolume();
        } // задаём граничное значение, прибавлять на 1 можно только до 100 (т.е. < 101)
        assertEquals(100, radio.getCurrentVolume());
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    } // при попытке увеличения громкости, когда она на максимуме, она остаётся на показателе 100.

    @Test
    void sholdDecreaseVolumeByOne() {
        Radio radio = new Radio();
        radio.increaseVolume();
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    } // Проверяем логику прибавления / убавления значения - изначально громкость на 0, прибавляем на 1, затем убавляем и становится снова 0

    @Test
    void shouldNotGoBeLowMinVolume0() {
        Radio radio = new Radio();
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    } // Снижать громкость ниже 0 нельзя, если попытаться уменьшить во время 0, останется 0

    @Test
    void shouldGetInitialStation() {
        Radio radio = new Radio();
        assertEquals(0, radio.getCurrentStation());
    } // Начальное значение станции = 0

    @Test
    void shouldSetValidStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    } // Берём срединное значение 5, должно приниматься и выводить 5

    @Test
    void shouldIgnoreInvalidStationBelowRange() {
        Radio radio = new Radio();
        radio.setCurrentStation(3);
        radio.setCurrentStation(-1);
        assertEquals(3, radio.getCurrentStation());
    } // Проверка корректности - ставим 3, принимается 3. Если после этого пробуем ставить несуществующее значение -1, то остаётся 3

    @Test
    void shouldIgnoreInvalidStationAboveRange() {
        Radio radio = new Radio();
        radio.setCurrentStation(7);
        radio.setCurrentStation(10);
        assertEquals(7, radio.getCurrentStation());
    } // Такая же проверка, как и предыдущая, но с положительным числом выше возможного (то есть 10, а радиостанций макс 9)

    @Test
    void shouldGoNextInMiddleRange() {
        Radio radio = new Radio();
        radio.setCurrentStation(4);
        radio.next();
        assertEquals(5, radio.getCurrentStation());
    } // при переключении станции со срединного значения (4) на следующую станцию, получаем следующую цифру (5)

    @Test
    void shouldWrapNextFrom9To0() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    } // Если стоит макс станция 9, то при переключении дальше, получим отсчёт заново (т.е. станцию 0)

    @Test
    void shouldGoPrevInMiddleRange() {
        Radio radio = new Radio();
        radio.setCurrentStation(6);
        radio.prev();
        assertEquals(5, radio.getCurrentStation());
    } // Если стоит станция 6, то при нажатии кнопки prev станция переключается на предыдущую - 5

    @Test
    void shouldWrapPrevFrom0To9() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    } // И соответственно при переключении назад со станции 0, получаем станцию 9
}
