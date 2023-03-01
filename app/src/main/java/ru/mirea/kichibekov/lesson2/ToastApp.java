package ru.mirea.kichibekov.lesson2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ToastApp extends AppCompatActivity {
    String student = "СТУДЕНТ № 12 ГРУППА БСБО-03-20";
    EditText editText;
    Button button;;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_app);
        editText = findViewById(R.id.userNameField);
        button = findViewById(R.id.search_number);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        student + " Количество символов - " + String.valueOf(editText.getText()).length(),
                        Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
    public void goFirst(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goBlog(View view) {
        Intent intent = new Intent(this, IntentFilter.class);
        startActivity(intent);
    }
}