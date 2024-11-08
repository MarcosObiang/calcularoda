package com.marcosobiang.micalculadora;

import static Verificacion.Operaciones.operaciones;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;

import Verificacion.Operaciones;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String screenText;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        screenText = "";
        textView = findViewById(R.id.textView);


        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button buttonMulti = findViewById(R.id.buttonMulti);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button buttonAdd = findViewById(R.id.button_add);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button buttonResta = findViewById(R.id.button_resta);
        Button buttonErase = findViewById(R.id.button_erase);
        Button button0 = findViewById(R.id.button0);
        Button buttonEquals = findViewById(R.id.button_equals);
        Button buttonDiv = findViewById(R.id.button_div);


    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.button) {
            screenText += "1";
        }

        if (view.getId() == R.id.button2) {
            screenText += "2";
        }
        if (view.getId() == R.id.button3) {
            screenText += "3";

        }
        if (view.getId() == R.id.button4) {
            screenText += "4";
        }
        if (view.getId() == R.id.button5) {
            screenText += "5";
        }
        if (view.getId() == R.id.button6) {
            screenText += "6";
        }
        if (view.getId() == R.id.button7) {
            screenText += "7";
        }
        if (view.getId() == R.id.button8) {
            screenText += "8";
        }

        if (view.getId() == R.id.button9) {
            screenText += "9";
        }
        if (view.getId() == R.id.button0) {
            screenText += "0";
        }

        if (view.getId() == R.id.button_add) {
            screenText += "+";
        }

        if (view.getId() == R.id.button_resta) {
            screenText += "-";
        }

        if (view.getId() == R.id.buttonMulti) {
            screenText += "*";
        }

        if (view.getId() == R.id.button_div) {
            screenText += "/";
        }
        if (view.getId() == R.id.button_equals) {
            screenText = String.valueOf(operaciones.calcular(String.valueOf(screenText)));
        }
        if (view.getId() == R.id.button_erase) {
            operaciones.borrar();
            screenText="";
        }

        textView.setText(screenText);


    }
}