//Thi Thanh Tra KIEU #261066512
package com.teaching.myrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    FrameLayout nem, banhmi, bbtea, mochi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }

    }

    public void clickFrame(View view) {
        nem = findViewById(R.id.nem);
        banhmi = findViewById(R.id.banhmi);
        bbtea = findViewById(R.id.bbtea);
        mochi = findViewById(R.id.mochi);

        Intent intent = new Intent(MainActivity.this, FoodListActivity.class);
        if (view == nem) {
            intent.putExtra("framelayout", "nem");
        } else if (view == banhmi) {
            intent.putExtra("framelayout", "banhmi");
        } else if (view == bbtea) {
            intent.putExtra("framelayout", "bbtea");
        } else {
            intent.putExtra("framelayout", "mochi");
        }
        startActivity(intent);
        }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        startActivity(intent);
        return;
    }

}