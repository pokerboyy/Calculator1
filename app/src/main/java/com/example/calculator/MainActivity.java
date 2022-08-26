package com.example.calculator;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView inputText, outputText;
    private String input;
    private String output;
    private String newOutput;
    private Button button0, button1, button2, button3, button4, button5, button6, button7,
            button8, button9, buttonAdd, buttonMultiply, buttonSubtract, buttonDivide, buttonPercent,
            buttonPower, buttonClear, buttonEqual, buttonPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button0 = findViewById(R.id.btn0);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button4 = findViewById(R.id.btn4);
        button5 = findViewById(R.id.btn5);
        button6 = findViewById(R.id.btn6);
        button7 = findViewById(R.id.btn7);
        button8 = findViewById(R.id.btn8);
        button9 = findViewById(R.id.btn9);
        buttonAdd = findViewById(R.id.btn_add);
        buttonSubtract = findViewById(R.id.btn_sub);
        buttonMultiply = findViewById(R.id.btn_mul);
        buttonDivide = findViewById(R.id.btn_divide);
        buttonPercent = findViewById(R.id.btn_percent);
        buttonPower = findViewById(R.id.btn_power);
        buttonClear = findViewById(R.id.btn_clr);
        buttonEqual = findViewById(R.id.btn_equal);
        buttonPoint = findViewById(R.id.btn_decimal);
        inputText = findViewById(R.id.input);
        outputText = findViewById(R.id.output);
    }

    public void onButtonClicked(View view) {

        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data) {
            case "C":
                input = null;
                output = null;
                newOutput = null;
                outputText.setText("");
                break;

            case "^":
               if(input==null)
                   break;
               else {
                   solve();
                   input += "^";
                   break;
               }
            case "*":
              if(input==null)
                  break;
              else {
                  solve();
                  input += "*";
                  break;
              }

            case "=":
                if(input==null || input.equals(""))
                    break;
                else {
                    solve();
                    break;
                }

            case "%":
                if(input==null) {
                    input = "";
                }


                else {
                    input += "%";
                    try {
                        double d = Double.parseDouble(inputText.getText().toString()) / 100;
                        outputText.setText(String.valueOf(d));
                    }
                    catch (NumberFormatException ex){
                        
                    }
                    break;
                }

            default:
                if (input == null) {
                    input = "";
                }
                if (data.equals("+") || data.equals("/") || data.equals("-")) {
                    solve();
                }
                input += data;
        }
        inputText.setText(input);
    }

    private void solve() {
        if (input.split("\\+").length == 2) {
            String numbers[] = input.split("\\+");
            try {
                double d = Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = output;
                outputText.setText(newOutput);
                input = Double.toString(d);
                Log.e(TAG, "input: " + input);
            } catch (Exception e) {
                outputText.setText(e.getMessage().toString());
            }
        }
        if (input.split("\\*").length == 2) {
            String numbers[] = input.split("\\*");
            try {
                double d = Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = output;
                outputText.setText(newOutput);
                input = d + "";
            } catch (Exception e) {
                outputText.setText(e.getMessage().toString());
            }
        }
        if (input.split("\\/").length == 2) {
            String numbers[] = input.split("\\/");
            try {
                double d = Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = output;
                outputText.setText(newOutput);
                input = d + "";
            } catch (Exception e) {
                outputText.setText(e.getMessage().toString());
            }
        }
        if (input.split("\\-").length == 2) {
            String numbers[] = input.split("\\-");
            try {
                double d = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = output;
                outputText.setText(newOutput);
                input = d + "";
            } catch (Exception e) {
                outputText.setText(e.getMessage().toString());
            }
        }

            if (input.split("\\^").length == 2) {
                String numbers[] = input.split("\\^");
                try {
                    double d = Math.pow(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]));
                    output = Double.toString(d);
                    newOutput = output;
                    outputText.setText(newOutput);
                    input = d + "";
                } catch (Exception e) {
                    outputText.setText(e.getMessage().toString());
                }
            }
        }
    }




