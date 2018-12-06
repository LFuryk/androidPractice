package com.example.lfuryk.myApp;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lfuryk.firstapp.R;

public class ConversorActivity extends AppCompatActivity implements MainPresenter.ConversorView {


    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        presenter = new MainPresenter(this);

        Button button = findViewById(R.id.ConvertirButton);

        button.setOnClickListener(myListener);

    }

    private View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TextInputEditText inputMiles = findViewById(R.id.inputMillas);

            String inputedMiles = inputMiles.getText().toString();

            presenter.updateResult(inputedMiles);
        }
    };

    @Override
    public void updateResult(String info) {
        TextView resultTextView = findViewById(R.id.resultTextView);
        resultTextView.setText(info);
    }

}