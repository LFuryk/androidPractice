package com.example.lfuryk.firstapp;

import com.example.lfuryk.myApp.Conversor;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ConversorTest {

    @Test
    public void verifyCorrectInitialization(){
        Conversor conversor = new Conversor();

        assertEquals(0.0, conversor.getKilometers());
        assertEquals(0.0, conversor.getMiles());

    }

    @Test
    public void verifyCorrectConvertion(){

        Conversor conversor = new Conversor();

        conversor.setMiles(1);

        assertEquals(1.0, conversor.getMiles());

        conversor.convert();

        assertEquals(1.60934, conversor.getKilometers());
    }
}
