package com.eduardorascon.gasolina;

public class StateInfo {
    private String mStateName;

    StateInfo(String stateName) {
        mStateName = stateName;
    }

    public String getStateName() {
        switch (mStateName) {
            case "COAHUILA DE ZARAGOZA":
                return "COAHUILA";
            case "MICHOACÁN DE OCAMPO":
                return "MICHOACÁN";
            case "VERACRUZ DE IGNACIO DE LA LLAVE":
                return "VERACRUZ";
            default:
                return mStateName;
        }
    }
}
