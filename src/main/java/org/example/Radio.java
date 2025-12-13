package org.example;

public class Radio {
    // Два состояния у радио:
    private int currentStation; // станции от 0 до 9
    private int currentVolume; // громкость от 0 до 100

    // Ставим геттер для прочтения и тестирования приватных полей в значениях громкости
    public int getCurrentVolume() {
        return currentVolume;
    }

    // Если громкость меньше 100, мы можем прибавить на +1, но макс до 100
    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume = currentVolume + 1;
        }
    }
    // Если громкость больше 0, мы можем убавить на -1, но мин до 0
    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume = currentVolume - 1;
        }
    }

    // Ставим геттер для прочтения и тестирования приватных полей в значениях станции
    public int getCurrentStation() {
        return currentStation;
    }

    // Прописываем "границы" для станции от 0 до 9
    public void setCurrentStation(int station) {
        if (station >= 0 && station <= 9) {
            currentStation = station;
        }
    }

    // Добавляем переключение станций (если станция уже 9-я, то +1 сделает её 0-й и наоборот -1 вернёт её к 0)
    public void next() {
        if (currentStation ==9) {
            currentStation = 0;
        } else {
            currentStation = currentStation + 1;
        }
    }
    public void prev() {
        if (currentStation == 0) {
            currentStation = 9;
        } else {
            currentStation = currentStation - 1;
        }
    }
}