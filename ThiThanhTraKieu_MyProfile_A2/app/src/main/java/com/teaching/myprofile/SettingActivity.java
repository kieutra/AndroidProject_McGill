package com.teaching.myprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.content.SharedPreferences;

public class SettingActivity extends AppCompatActivity {
    Spinner spinner;
    Button button;
    final String storedTheme = "stored theme";
    final String storedValue = "spinner's stored value";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        spinner = (Spinner) findViewById(R.id.spinner);
        readCurrentSpinnerValue();
        changeThemeInMain();
    }

    //set up value in spinner from storedValue
    private void readCurrentSpinnerValue(){
        SharedPreferences sf = getSharedPreferences(storedTheme,MODE_PRIVATE);
        String savedValue = sf.getString(storedValue, "");
        for(int i=0; i<4; i++){
            if(savedValue.equals(spinner.getItemAtPosition(i).toString())){
                spinner.setSelection(i);
                break;
            }
        }
    }
    private void changeThemeInMain(){
        button = (Button) findViewById(R.id.button2);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String s = adapterView.getSelectedItem().toString();

                // save current theme by SharedPreferences
                    SharedPreferences sf = getSharedPreferences(storedTheme,MODE_PRIVATE);
                    SharedPreferences.Editor edit = sf.edit();
                    edit.putString(storedValue, s);
                    edit.apply();

                //Send to MainActivity and Change its theme
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra(storedValue, s);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }


}