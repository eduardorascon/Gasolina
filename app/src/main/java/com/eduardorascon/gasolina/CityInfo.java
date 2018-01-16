package com.eduardorascon.gasolina;

public class CityInfo {
    private final String cityName;
    private final String magna;
    private final String premium;
    private final String diesel;
    private final String date;

    CityInfo(String cityName, String cityPrices) {
        this.cityName = cityName;
        String[] prices = cityPrices.split("|");
        this.magna = prices[0];
        this.premium = prices[1];
        this.diesel = prices[2];
        this.date = prices[3];
    }

    public String getCityName() {
        return cityName;
    }

    public String getMagna() {
        return magna;
    }

    public String getPremium() {
        return premium;
    }

    public String getDiesel() {
        return diesel;
    }

    public String getDate() {
        return date;
    }
}
