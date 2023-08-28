package com.haikal.siklushidup;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText komentar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        komentar = findViewById(R.id.komentar_text);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "App on Start", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "App on Resume", Toast.LENGTH_SHORT).show();

        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String s1 = sh.getString("komentar", "");

        komentar.setText(s1);

    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "App on Pause", Toast.LENGTH_SHORT).show();

        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        myEdit.putString("komentar", komentar.getText().toString());
        myEdit.apply();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "App on Stop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "App on Destroy", Toast.LENGTH_SHORT).show();
    }
}