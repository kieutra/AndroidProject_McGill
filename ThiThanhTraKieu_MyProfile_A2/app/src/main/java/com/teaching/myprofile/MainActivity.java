//Thi Thanh Tra Kieu #261 066 512
package com.teaching.myprofile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Button button;
    ConstraintLayout layout;
    TextView tv;
    final String storedTheme = "stored theme";
    final String storedValue = "spinner's stored value";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.main_layout);
        layout.setBackgroundResource(R.drawable.spring);

        goToSetting();
        setLayout();
        loadLastestTheme();
    }

//    Go to SettingActivity
    private void goToSetting(){
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SettingActivity.class);
                startActivity(intent);
            }
        });
    }

//    Set background picture by season
    private void getSeason(String s){
        if (s.equals("Spring")) {
            layout.setBackgroundResource(R.drawable.spring);
        } else if (s.equals("Summer")) {
            layout.setBackgroundResource(R.drawable.summer);
        } else if (s.equals("Autumn")) {
            layout.setBackgroundResource(R.drawable.autumn);
        } else {
            layout.setBackgroundResource(R.drawable.winter);
        }
    }

//    Set background picture by taking season's name from ActivitySetting
    private void setLayout(){
        layout = findViewById(R.id.main_layout);
        tv = (TextView)findViewById(R.id.aboutMe);
        Intent i = getIntent();
        if(i != null && i.getStringExtra(storedValue)!=null){
            String s = i.getStringExtra(storedValue);
            getSeason(s);
        }
    }

//    Read saved latest background picture
    private void loadLastestTheme(){
        SharedPreferences sf = getSharedPreferences(storedTheme,MODE_PRIVATE);
        String savedValue = sf.getString(storedValue, "");
        getSeason(savedValue);
    }
}