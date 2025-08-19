package com.example.calculatorgrid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView displayTextView;
    private StringBuilder currentNumber = new StringBuilder();
    private double firstValue = Double.NaN;
    private String currentOperator = "";
    private boolean operatorPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayTextView = findViewById(R.id.display_text_view);
        setClickListeners();
    }

    private void setClickListeners() {
        // Find all buttons by their IDs and set a single onClickListener
        int[] buttonIds = {
                R.id.button_0, R.id.button_1, R.id.button_2, R.id.button_3, R.id.button_4,
                R.id.button_5, R.id.button_6, R.id.button_7, R.id.button_8, R.id.button_9,
                R.id.button_dot, R.id.button_add, R.id.button_subtract, R.id.button_multiply,
                R.id.button_divide, R.id.button_percent, R.id.button_clear, R.id.button_delete,
                R.id.button_equals
        };

        for (int id : buttonIds) {
            findViewById(id).setOnClickListener(this::onButtonClick);
        }
    }

    private void onButtonClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();

        switch (buttonText) {
            case "C":
                // Clear everything
                currentNumber.setLength(0);
                firstValue = Double.NaN;
                currentOperator = "";
                operatorPressed = false;
                displayTextView.setText("0");
                break;
            case "DEL":
                // Delete the last character
                if (currentNumber.length() > 0) {
                    currentNumber.deleteCharAt(currentNumber.length() - 1);
                    displayTextView.setText(currentNumber.length() > 0 ? currentNumber.toString() : "0");
                }
                break;
            case "=":
                // Perform the calculation
                if (firstValue != Double.NaN && currentNumber.length() > 0) {
                    double secondValue = Double.parseDouble(currentNumber.toString());
                    double result = calculate(firstValue, secondValue, currentOperator);
                    // Format the result to avoid scientific notation
                    DecimalFormat df = new DecimalFormat("#.##########");
                    displayTextView.setText(df.format(result));
                    firstValue = result;
                    currentNumber.setLength(0);
                    operatorPressed = false;
                }
                break;
            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
                // Handle operator clicks
                if (currentNumber.length() > 0) {
                    if (operatorPressed) {
                        double secondValue = Double.parseDouble(currentNumber.toString());
                        double result = calculate(firstValue, secondValue, currentOperator);
                        firstValue = result;
                        currentNumber.setLength(0);
                        DecimalFormat df = new DecimalFormat("#.##########");
                        displayTextView.setText(df.format(result));
                    } else {
                        firstValue = Double.parseDouble(currentNumber.toString());
                        currentNumber.setLength(0);
                        operatorPressed = true;
                    }
                    currentOperator = buttonText;
                }
                break;
            default:
                // Handle number and dot clicks
                if (operatorPressed) {
                    currentNumber.setLength(0);
                    operatorPressed = false;
                }
                currentNumber.append(buttonText);
                displayTextView.setText(currentNumber.toString());
                break;
        }
    }

    private double calculate(double value1, double value2, String operator) {
        switch (operator) {
            case "+": return value1 + value2;
            case "-": return value1 - value2;
            case "*": return value1 * value2;
            case "/": return value1 / value2;
            case "%": return value1 % value2;
            default: return 0;
        }
    }
}