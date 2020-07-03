package com.example.bt_tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MechanismActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mechanism);
    }

    public void backToHome(View view) {
        Intent backHome = new Intent(this, MainActivity.class);
        startActivity(backHome);
    }

    public void goToLink1(View view) {
        Intent toLink1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.scientificamerican.com/article/what-causes-a-fever/"));

        startActivity(toLink1);
    }
}
