package com.javierms.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnDot,btnPlus,btnMinus,btnMulti,btnDivide,btnAC,btnDel, btnEqual;

    private TextView txtHistory, txtResult;

    private String number = null;

    double firstNumber = 0;
    double lastNumber = 0;

    String status = null;
    boolean operator = false;

    DecimalFormat miFormatter = new DecimalFormat("######.######");

    String history,currentResult;

    boolean dot = true;
    boolean btnACControl = true;
    boolean equalControl = false;
    boolean equalFinal = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnDot = findViewById(R.id.btnDot);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMulti = findViewById(R.id.btnMulti);
        btnDivide = findViewById(R.id.btnDivide);

        btnAC = findViewById(R.id.btnAC);
        btnDel = findViewById(R.id.btnDel);
        btnEqual = findViewById(R.id.btnEqual);

        txtHistory = findViewById(R.id.txtHistory);
        txtResult = findViewById(R.id.txtResult);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick("9");
            }
        });

        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                number = null;
                status = null;
                txtResult.setText("0");
                txtHistory.setText("");
                firstNumber = 0;
                lastNumber = 0;
                dot = true;
                btnACControl = true;

            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(btnACControl == true){
                    txtResult.setText("0");
                } else {
                    number = number.substring(0, number.length() - 1);

                    if(number.length() == 0){
                        btnDel.setClickable(false);
                    } else if (number.contains(".")){
                        dot = false;
                    } else {
                        dot = true;
                    }

                    if(number.length() == 0){
                        txtResult.setText("0");
                        firstNumber = 0;
                    } else {
                        txtResult.setText(number);
                    }


                }



            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                history = txtHistory.getText().toString();
                currentResult = txtResult.getText().toString();
                txtHistory.setText(history+currentResult+"+");


                if(operator == true){
                    if (status == "multi"){
                        multiply();
                    } else if (status == "division"){
                        divide();
                    } else if (status == "substraction"){
                        minus();
                    } else {
                        plus();
                    }
                }

                status = "sum";
                operator = false;
                number = null;

            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                history = txtHistory.getText().toString();
                currentResult = txtResult.getText().toString();
                txtHistory.setText(history+currentResult+"-");

                if(operator == true){
                    if (status == "multi"){
                        multiply();
                    } else if (status == "division"){
                        divide();
                    } else if (status == "sum"){
                        plus();
                    } else {
                        minus();
                    }
                }

                status = "substraction";
                operator = false;
                number = null;

            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                history = txtHistory.getText().toString();
                currentResult = txtResult.getText().toString();
                txtHistory.setText(history+currentResult+"/");

                if(operator == true){
                    if (status == "multi"){
                        multiply();
                    } else if (status == "substraction"){
                        minus();
                    } else if (status == "sum"){
                        plus();
                    } else {
                        divide();
                    }
                }

                status = "division";
                operator = false;
                number = null;

            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                history = txtHistory.getText().toString();
                currentResult = txtResult.getText().toString();
                txtHistory.setText(history+currentResult+"*");

                if(operator == true){
                    if (status == "division"){
                        divide();
                    } else if (status == "substraction"){
                        minus();
                    } else if (status == "sum"){
                        plus();
                    } else {
                        multiply();
                    }
                }

                status = "multi";
                operator = false;
                number = null;

            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                history = txtHistory.getText().toString();
                currentResult = txtResult.getText().toString();

                if(equalFinal == true) {
                    txtHistory.setText(history + currentResult + "=");
                    btnEqual.setClickable(false);
                }

                if (operator == true){
                    if (status == "division"){
                        divide();
                    } else if (status == "substraction"){
                        minus();
                    } else if (status == "sum"){
                        plus();
                    } else if (status == "multi"){
                        multiply();
                    } else {
                        firstNumber = Double.parseDouble(txtResult.getText().toString());
                    }
                }

                operator = false;
                equalFinal = false;


            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (number == null && dot == true){
                    number = "0.";
                } else if (number != null && dot == true){
                    number = number + ".";
                }

                txtResult.setText(number);
                dot = false;

            }
        });

    }

    public void numberClick(String view){

        if(number == null){
            number = view;
        } else if (equalControl == true){
            firstNumber = 0;
            lastNumber = 0;
            number = view;
        } else {
            number = number + view;
        }

        txtResult.setText(number);
        operator = true;
        btnACControl = false;
        btnDel.setClickable(true);
        equalControl = false;
        equalFinal = true;

    }

    public void plus(){
        lastNumber = Double.parseDouble(txtResult.getText().toString());
        firstNumber = firstNumber + lastNumber;
        txtResult.setText(miFormatter.format(firstNumber));
        dot = true;
        equalFinal = true;
        btnEqual.setClickable(true);

    }

    public void minus(){
        if (firstNumber == 0){
            firstNumber = Double.parseDouble(txtResult.getText().toString());
        } else {
            lastNumber = Double.parseDouble(txtResult.getText().toString());
            firstNumber = firstNumber - lastNumber;
        }

        txtResult.setText(miFormatter.format(firstNumber));
        dot = true;
        equalFinal = true;
        btnEqual.setClickable(true);

    }

    public void multiply(){
        if (firstNumber == 0){
            firstNumber = 1;
            lastNumber = Double.parseDouble(txtResult.getText().toString());
            firstNumber = firstNumber * lastNumber;

        } else {
            lastNumber = Double.parseDouble(txtResult.getText().toString());
            firstNumber = firstNumber * lastNumber;
        }

        txtResult.setText(miFormatter.format(firstNumber));
        dot = true;
        equalFinal = true;
        btnEqual.setClickable(true);
    }

    public void divide(){
        if (firstNumber == 0){
            lastNumber = Double.parseDouble(txtResult.getText().toString());
            firstNumber = lastNumber / 1;

        } else {
            lastNumber = Double.parseDouble(txtResult.getText().toString());
            firstNumber = firstNumber / lastNumber;
        }

        txtResult.setText(miFormatter.format(firstNumber));
        dot = true;
        equalFinal = true;
        btnEqual.setClickable(true);
    }




}