package com.example.hellotoast;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private int clickCount = 0;
    private TextView textViewCount;


    //clave para el valor del contador en el Bundle
    private static final String COUNT_KEY ="count";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonToast = findViewById(R.id.buttonToast);
        Button buttonCount = findViewById(R.id.buttonCount);
        textViewCount = findViewById(R.id.textViewCount);

        //Restaurar el valor de clickCount si el estado anterior está disponible

        if (savedInstanceState !=null) {
    clickCount = savedInstanceState.getInt(COUNT_KEY, 0);
    textViewCount.setText(String.valueOf(clickCount));
        }

        buttonToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Hello toast!", Toast.LENGTH_SHORT).show();
            }
        });

        buttonCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount++;
                textViewCount.setText(String.valueOf(clickCount));
            }
        });
    }

//Guardar el valor de clickCount cuando se recrea la actividad

@Override
protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putInt(COUNT_KEY, clickCount);
    }

    //Restaurar el valor de clickCount cuando se recrea la actividad en onCreate

@Override
protected void onRestoreInstanceState(Bundle saveInstanceState) {
    super.onRestoreInstanceState(saveInstanceState);
    clickCount = saveInstanceState.getInt(COUNT_KEY, 0);
    textViewCount.setText(String.valueOf(clickCount));

}

}