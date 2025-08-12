package com.example.simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText num1,num2;
    TextView result;
    Button btnadd,btnsub,btnmul,btndiv;


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
        num1=findViewById(R.id.number1);
        num2=findViewById(R.id.number2);
        btnadd=findViewById(R.id.button1);
        btnsub=findViewById(R.id.button2);
        btnmul=findViewById(R.id.button3);
        btndiv=findViewById(R.id.button4);
        result=findViewById(R.id.Result);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a=Integer.parseInt(num1.getText().toString());
                int b=Integer.parseInt(num2.getText().toString());
                result.setText("Result "+(a+b));
            }
        });
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a=Integer.parseInt(num1.getText().toString());
                int b=Integer.parseInt(num2.getText().toString());
                result.setText("Result "+(a-b));
            }
        });
        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a=Integer.parseInt(num1.getText().toString());
                int b=Integer.parseInt(num2.getText().toString());
                result.setText("Result "+(a*b));
            }
        });
        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a=Integer.parseInt(num1.getText().toString());
                int b=Integer.parseInt(num2.getText().toString());
                result.setText("Result "+(a/b));
            }
        });

        }

    }
