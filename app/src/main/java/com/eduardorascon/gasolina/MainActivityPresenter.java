package com.eduardorascon.gasolina;

import com.eduardorascon.gasolina.repositories.StatesRepository;

import java.util.List;

public class MainActivityPresenter {
    private MainActivityView view;
    private StatesRepository statesRepository;

    public MainActivityPresenter(MainActivityView view, StatesRepository statesRepository) {

        this.view = view;
        this.statesRepository = statesRepository;
    }

    public void loadStates() {
        List<String> stateList = statesRepository.getStateList();
        view.displayStates(stateList);
    }
}
