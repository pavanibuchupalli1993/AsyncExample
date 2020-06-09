package com.example.asyncexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainActivityInterface{

    private Button button;
    public EditText time;
    private TextView finalResult;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time = findViewById(R.id.in_time);
        button = findViewById(R.id.btn_run);
        finalResult =  findViewById(R.id.tv_result);
        presenter=new Presenter(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.startTimer();

            }
        });


    }

    @Override
    public void displayResult(String result) {

        finalResult.setText(result);
    }
}
