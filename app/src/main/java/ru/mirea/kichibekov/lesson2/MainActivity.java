package ru.mirea.kichibekov.lesson2;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.contentcapture.DataRemovalRequest;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener {
    EditText editText;
    Button timeButton;
    Button dateButton;
    Button progressButton;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //editText = findViewById(R.id.userNameField);
        //String text = String.valueOf(editText.getText());
        timeButton = findViewById(R.id.timeButton);
        dateButton = findViewById(R.id.dateButton);
        progressButton = findViewById(R.id.progressButton);

        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new MyTimeDialogFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new MyDateDialogFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

        progressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.show();
                progressDialog.setContentView(R.layout.progress_dialog);
                progressDialog.getWindow().setBackgroundDrawableResource(
                        android.R.color.transparent
                );
            }
        });
    }

    @Override
    public void onBackPressed() {
        progressDialog.dismiss();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart()");
    }

    public void goSecond2(View view) {
        Intent intent = new Intent(this, MultiActivity.class);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "MIREA");
        intent.putExtra(Intent.EXTRA_TEXT,"Кичибеков Рахман Фархадович");
        startActivity(Intent.createChooser(intent, "Мои ФИО"));
    }

    public void goSecond(View view) {
        Intent intent = new Intent(this, MultiActivity.class);
        intent.putExtra("key", "MIREA - Кичибеков Рахман Фархадович");
        startActivity(intent);
    }

    public void goBlog(View view) {
        Intent intent = new Intent(this, IntentFilter.class);
        startActivity(intent);
    }

    public void goCountWords(View view) {
        Intent intent = new Intent(this, ToastApp.class);
        startActivity(intent);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        TextView textTime = findViewById(R.id.textTime);
        textTime.setText("Hour: " + hourOfDay + " Minute: " + minute);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        TextView textView = findViewById(R.id.textDate);
        textView.setText(currentDate);
    }
}