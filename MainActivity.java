package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText result;
    private EditText newNumber;
    private TextView displayOperation;

    private Double operand1;
    private String pendingOperation="=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result=findViewById(R.id.result);
        newNumber=findViewById(R.id.newNumber);
        displayOperation=findViewById(R.id.operation);

        Button button0=findViewById(R.id.button0);
        Button button1=findViewById(R.id.button1);
        Button button2=findViewById(R.id.button2);
        Button button3=findViewById(R.id.button3);
        Button button4=findViewById(R.id.button4);
        Button button5=findViewById(R.id.button5);
        Button button6=findViewById(R.id.button6);
        Button button7=findViewById(R.id.button7);
        Button button8=findViewById(R.id.button8);
        Button button9=findViewById(R.id.button9);
        Button buttonDot=findViewById(R.id.buttonDot);

        Button buttonEquals=findViewById(R.id.buttonEquals);
        Button buttonDivide=findViewById(R.id.buttonDivide);
        Button buttonMultiply=findViewById(R.id.buttonMultiply);
        Button buttonPlus=findViewById(R.id.buttonPlus);
        Button buttonMinus=findViewById(R.id.buttonMinus);

        View.OnClickListener onClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b=(Button) v;
                newNumber.append(b.getText().toString());
            }
        };
        button0.setOnClickListener(onClickListener);
        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        button5.setOnClickListener(onClickListener);
        button6.setOnClickListener(onClickListener);
        button7.setOnClickListener(onClickListener);
        button8.setOnClickListener(onClickListener);
        button9.setOnClickListener(onClickListener);
        buttonDot.setOnClickListener(onClickListener);

        View.OnClickListener onClickListener1=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b1=(Button) v;
                String op=b1.getText().toString();
                String value=newNumber.getText().toString();
                if(value.length()!=0){
                    performOperation(value,op);
                }
                pendingOperation=op;
                displayOperation.setText(pendingOperation);
            }
        };
        buttonDivide.setOnClickListener(onClickListener1);
        buttonEquals.setOnClickListener(onClickListener1);
        buttonMinus.setOnClickListener(onClickListener1);
        buttonMultiply.setOnClickListener(onClickListener1);
        buttonPlus.setOnClickListener(onClickListener1);
    }
    @SuppressLint("SetTextI18n")
    private void performOperation(String value, String operation) {
        if (null == operand1) {
            operand1 = Double.valueOf(value);
        } else {
            Double operand2 = Double.valueOf(value);

            if (pendingOperation.equals("=")) {
                pendingOperation = operation;
            }
            switch (pendingOperation) {
                case "=":
                    operand1 = operand2;
                    break;
                case "/":
                    if (operand2 == 0) {
                        operand1 = 0.0;
                    } else {
                        operand1 /= operand2;
                    }
                    break;
                case "*":
                    operand1 *= operand2;
                    break;
                case "-":
                    operand1 -= operand2;
                    break;
                case "+":
                    operand1 += operand2;
                    break;
            }
        }

        result.setText(operand1.toString());
        newNumber.setText("");

    }

}


