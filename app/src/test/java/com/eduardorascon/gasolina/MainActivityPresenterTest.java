package com.eduardorascon.gasolina;

import com.eduardorascon.gasolina.repositories.StatesRepository;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MainActivityPresenterTest {

    @Test
    public void ShouldPass() {
        Assert.assertEquals(1, 1);
    }

    @Test
    public void ShouldPassStatesListToView() {
        //given
        MainActivityView view = new MockView();
        StatesRepository statesRepository = new MockStateRepository();
        //when
        MainActivityPresenter presenter = new MainActivityPresenter(view, statesRepository);
        presenter.loadStates();
        //then
        Assert.assertEquals(true, ((MockView) view).passed);
    }

    private class MockView implements MainActivityView {
        boolean passed = false;

        @Override
        public void displayStates(List<String> stateList) {
            if (stateList.size() > 0) passed = true;
        }

        @Override
        public void showCitiesActivity() {

        }
    }

    private class MockStateRepository implements StatesRepository {

        @Override
        public List<String> getStateList() {
            return Arrays.asList("Aguascalientes", "Chihuahua", "Zacatecas");
        }
    }
}