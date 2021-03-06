package com.teaching.midterm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton add;
    RadioButton sub;
    RadioButton multi;
    RadioButton div;
    TextView leftOP, rightOP, operator, equal, result;
    ToggleButton toggleButton;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    String leftStr ="";
    String rightStr ="";
    int finalResult;
    int Left =1;
    ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = findViewById(R.id.radioGroup);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        multi = findViewById(R.id.multi);
        div = findViewById(R.id.div);
        operator = findViewById(R.id.operator);
        leftOP = findViewById(R.id.LefOp);
        rightOP = findViewById(R.id.RightOP);
        toggleButton = findViewById(R.id.toggleButton);
        btn0 = findViewById(R.id.button11);
        btn1 = findViewById(R.id.button9);
        btn2 = findViewById(R.id.button8);
        btn3 = findViewById(R.id.button7);
        btn4 = findViewById(R.id.button6);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button4);
        btn7 = findViewById(R.id.button3);
        btn8 = findViewById(R.id.button2);
        btn9 = findViewById(R.id.button);
        equal = findViewById(R.id.textView4);
        result = findViewById(R.id.textView5);



        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.add) operator.setText("+");
                else if (i == R.id.sub) operator.setText("-");
                else if (i == R.id.multi) operator.setText("*");
                else operator.setText("/");
            }
        });
    }

    public void clickToggle(View view){
        if (((ToggleButton) view).isChecked()) {
                    toggleButton.setTextOn("RIGHT");
                    Left =0;
        } else {
                    toggleButton.setTextOff("LEFT");
                    Left =1;
        }
    }
    public void clickButton(View view) {
        if (view instanceof Button) {
            Button button = (Button) view;

            if (Left==0) {
                rightStr += ((Button) view).getText().toString();
                rightOP.setText(rightStr);
            } else{
                leftStr += ((Button) view).getText().toString();
                leftOP.setText(leftStr);

            }
        }

    }

    public void clickResult(View view){
        if(leftOP.getText().toString().length()==0|| leftOP.getText().toString().length()==0){
            result.setText("Result");
            Toast.makeText(this,"The operand cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }else{
            if(operator.getText().toString().equals("+")){
                finalResult = Integer.parseInt(leftOP.getText().toString()) + Integer.parseInt(rightOP.getText().toString());
            }
            else if(operator.getText().toString().equals("-")){
                finalResult = Integer.parseInt(leftOP.getText().toString()) - Integer.parseInt(rightOP.getText().toString());
            }
            else if(operator.getText().toString().equals("*")){
                finalResult = Integer.parseInt(leftOP.getText().toString()) * Integer.parseInt(rightOP.getText().toString());
            }
            else{
                operator.getText().toString().equals("/");
                if(rightOP.getText().toString().equals("0")){
                    result.setText("Result");
                    Toast.makeText(this, "Cannot divide by 0", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    double divideResult;
                    divideResult = Double.parseDouble(leftOP.getText().toString()) / Double.parseDouble(rightOP.getText().toString());
                    result.setText("" + divideResult);
                    return;
                }
            }

        }

        result.setText("" + finalResult);
    }

    public void clickClearResult(View view){
        leftStr = "";
        rightStr = "";
        leftOP.setText("Left Operand");
        rightOP.setText("Right Operand");
        result.setText("Result");
    }

    public void clickSwitch(View view){
        layout = findViewById(R.id.layout);
        TextView [] array = {add, sub, multi, div, operator, equal};
        TextView [] array2 = {leftOP, rightOP, result};
        if (((Switch) view).isChecked()){
            layout.setBackgroundColor(Color.DKGRAY);
            leftOP.setHintTextColor(Color.WHITE);

            for(int i=0; i<array.length; i++){
                array[i].setTextColor(Color.WHITE);
            }
            for(int i=0; i<array2.length; i++){
                array2[i].setHintTextColor(Color.WHITE);
            }
            ((Switch)view).setTextColor(Color.WHITE);
        }else{
            layout.setBackgroundColor(Color.WHITE);
            for(int i=0; i<array.length; i++){
                array[i].setTextColor(Color.BLACK);
            }
            for(int i=0; i<array2.length; i++){
                array2[i].setHintTextColor(Color.BLACK);
            }
            ((Switch)view).setTextColor(Color.BLACK);
        }
    }
}
