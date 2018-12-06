package com.example.lfuryk.myApp;

import com.example.lfuryk.myApp.Conversor;

public class MainPresenter {

    private Conversor conversor;
    private ConversorView conversorView;

    MainPresenter(ConversorView conversorView){

        this.conversorView = conversorView;
        this.conversor = new Conversor();

    }

    void updateResult(String value){

        double miles;
        if(value.isEmpty()){
            miles = 0;
        }else{
            miles = Double.parseDouble(value);
        }

        conversor.setMiles(miles);
        conversor.convert();
        double kilometers = conversor.getKilometers();

        conversorView.updateResult(kilometers + "");

    }

    public interface ConversorView {

        void updateResult(String info);

    }


}
