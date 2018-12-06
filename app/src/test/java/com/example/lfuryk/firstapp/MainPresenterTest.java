package com.example.lfuryk.firstapp;

import com.example.lfuryk.myApp.Conversor;
import com.example.lfuryk.myApp.MainPresenter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    @Mock
    MainPresenter.ConversorView view;

    @Mock
    Conversor conversor;

    @Test
    public void verifyViewIsCalled(){

        when(conversor.getKilometers()).thenAnswer(new Answer<Double>() {
            @Override
            public Double answer(InvocationOnMock invocation) throws Throwable {
                return 5.0;
            }
        });


        MainPresenter presenter = new MainPresenter(view, conversor);

        presenter.updateResult("5");

        verify(view, times(1)).updateResult("5.0");

    }

    @Test
    public void verifyConversorIsCalled(){

        when(conversor.getKilometers()).thenAnswer(new Answer<Double>() {
            @Override
            public Double answer(InvocationOnMock invocation) throws Throwable {
                return 5.0;
            }
        });

        MainPresenter presenter = new MainPresenter(view, conversor);

        presenter.updateResult("5");

        verify(conversor, times(1)).setMiles(5.0);
        verify(conversor, times(1)).convert();
        verify(conversor, times(1)).getKilometers();
    }

    @Test
    public void verifyCorrectEmptyStringCase() {

        when(conversor.getKilometers()).thenAnswer(new Answer<Double>() {
            @Override
            public Double answer(InvocationOnMock invocation) throws Throwable {
                return 0.0;
            }
        });

        MainPresenter presenter = new MainPresenter(view, conversor);

        presenter.updateResult("");

        verify(conversor, times(1)).setMiles(0.0);
    }
}
