package com.eduardorascon.gasolina;

public class CityInfo {
    private final String cityName;
    private final String prices;

    CityInfo(String cityName, String prices) {
        this.cityName = cityName;
        this.prices = prices;
    }

    public String getCityName() {
        return cityName;
    }

    public String getPrices() {
        return prices;
    }
}
