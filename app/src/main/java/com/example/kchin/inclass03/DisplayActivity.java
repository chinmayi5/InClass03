package com.example.kchin.inclass03;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {
    public static final String NAME_EDIT = "name";
    public static final String EMAIL_EDIT = "email";
    public static final String DEPT_EDIT = "department";
    public static final String MOOD_EDIT = "mood";
    public static final int REQ_OK = 200;
    private Student student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();
        student = (Student) intent.getSerializableExtra(MainActivity.STUDENT_KEY);

        Log.d("Activity3", "Student Received " + student.toString());

        //nameButtonClicked(student);
        TextView name = findViewById(R.id.DisplayNamebox);
        TextView email = findViewById(R.id.DisplayEmailbox);
        TextView department = findViewById(R.id.DisplayDeparmentbox);
        TextView mood = findViewById(R.id.DisplayMoodbox);

        name.setText(student.getName());
        email.setText(student.getEmail());
        department.setText(student.getDepartment());
        mood.setText(student.getMood());

    }

    public void nameButtonClicked(View view){
        Intent intent = new Intent("com.example.kchin.inclass03.intent.action.VIEW");
        intent.putExtra(NAME_EDIT, student.getName());
        DisplayActivity.this.startActivityForResult(intent, REQ_OK);
    }

    protected void emailButtonClicked(View view){
        Intent intent = new Intent("com.example.kchin.inclass03.intent.action.VIEW");
        intent.putExtra(EMAIL_EDIT, student.getEmail());
        DisplayActivity.this.startActivityForResult(intent, REQ_OK);
    }

    protected void departmentButtonClicked(View view){
        Intent intent = new Intent("com.example.kchin.inclass03.intent.action.VIEW");
        intent.putExtra(DEPT_EDIT, student.getDepartment());
        DisplayActivity.this.startActivityForResult(intent, REQ_OK);
    }

    protected void moodButtonClicked(View view){
        Intent intent = new Intent("com.example.kchin.inclass03.intent.action.VIEW");
        intent.putExtra(MOOD_EDIT, student.getEmail());
        DisplayActivity.this.startActivityForResult(intent, REQ_OK);
    }

}
