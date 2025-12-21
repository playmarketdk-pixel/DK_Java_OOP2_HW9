package org.example;

public class Radio {
    // Три состояния у радио:
    private int currentStation; // станции от 0 до 9
    private int currentVolume; // громкость от 0 до 100
    private int stationsCount; // Хранит количество станций

    // Ниже конструкторы

    // Если пользователь пользователь не указал количество станций
    public Radio() {
        this.stationsCount = 10;
    }

    //Если пользователь сам задаёт кол-во станций
    public Radio(int stationsCount) {
        this.stationsCount = stationsCount;
    }

    // Ставим геттер для прочтения и тестирования приватных полей в значениях громкости
    public int getCurrentVolume() {
        return currentVolume;
    }

    // Увеличение громкости
    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    // Уменшение громкости
    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }

    // Ставим геттер для прочтения и тестирования приватных полей в значениях станции
    public int getCurrentStation() {
        return currentStation;
    }

    // Прописываем "границы" для станции от 0 до 9
    public void setCurrentStation(int station) {
        if (station >= 0 && station < stationsCount) {
            currentStation = station;
        }
    }

    // Геттер количества станций
    public int getStationsCount() {
        return stationsCount;
    }

    // Добавляем переключение станций (здесь - вперёд)
    public void next() {
        if (currentStation == stationsCount - 1) {
            currentStation = 0;
        } else {
            currentStation++;
        }
    }

    // И соответственно переключение назад
    public void prev() {
        if (currentStation == 0) {
            currentStation = stationsCount - 1;
        } else {
            currentStation--;
        }
    }
}