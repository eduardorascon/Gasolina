package com.eduardorascon.gasolina;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MainActivityPresenterTest {

    @Test
    public void ShouldPass() {
        Assert.assertEquals(1, 1);
    }

    @Test
    public void ShouldPassStatesListToView() {
        //given
        MainActivityView view = new MockView();
        //when
        MainActivityPresenter presenter = new MainActivityPresenter(view);
        presenter.loadStates();
        //then
        Assert.assertEquals(true, ((MockView) view).passed);
    }

    private class MockView implements MainActivityView {
        boolean passed = false;

        @Override
        public void displayStates(List<StateInfo> stateList) {
            if (stateList.size() > 0) passed = true;
        }
    }
}