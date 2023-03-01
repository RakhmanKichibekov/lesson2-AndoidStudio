package ru.mirea.kichibekov.lesson2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MultiActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi);
        textView = findViewById(R.id.textFromFirstActivity);
        String text = (String) getIntent().getSerializableExtra("key");
        textView.setText(text);
        Toast toast = Toast.makeText(getApplicationContext(),
                "Здравсвуй MIREA!",
                Toast.LENGTH_SHORT);
        toast.show();
    }

    public void goFirst(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}