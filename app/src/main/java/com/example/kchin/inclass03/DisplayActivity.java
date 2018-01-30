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
    public static final int REQ_OK = 200;
    public static final String VALUE_KEY = "value";
    private Student student;

    TextView mood;
    TextView department;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();
        student = (Student) intent.getSerializableExtra(MainActivity.STUDENT_KEY);

        Log.d("Activity3", "Student Received " + student.toString());

        TextView name = findViewById(R.id.DisplayNamebox);
        TextView email = findViewById(R.id.DisplayEmailbox);
        department = findViewById(R.id.DisplayDeparmentbox);
        mood = findViewById(R.id.DisplayMoodbox);

        name.setText(student.getName());
        email.setText(student.getEmail());
        department.setText(student.getDepartment());
        mood.setText(student.getMood());

    }

    public void nameButtonClicked(View view){
        Intent intent = new Intent("com.example.kchin.inclass03.intent.action.VIEW");
        intent.putExtra(NAME_EDIT, "name");
        DisplayActivity.this.startActivityForResult(intent, REQ_OK);
    }

    protected void emailButtonClicked(View view){
        Intent intent = new Intent("com.example.kchin.inclass03.intent.action.VIEW");
        intent.putExtra(NAME_EDIT, "email");
        DisplayActivity.this.startActivityForResult(intent, REQ_OK);
    }

    protected void departmentButtonClicked(View view){
        Intent intent = new Intent("com.example.kchin.inclass03.intent.action.VIEW");
        intent.putExtra(NAME_EDIT, "department");
        DisplayActivity.this.startActivityForResult(intent, REQ_OK);
    }

    protected void moodButtonClicked(View view){
        Intent intent = new Intent("com.example.kchin.inclass03.intent.action.VIEW");
        intent.putExtra(NAME_EDIT, "mood");
        DisplayActivity.this.startActivityForResult(intent, REQ_OK);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == REQ_OK){
            if(resultCode == RESULT_OK){
                String value = data.getStringExtra("mood");
                String dept = data.getStringExtra("dept");
                Log.d("Activity3", "Setting mood! " + value);
                mood.setText(value);
                department.setText(dept);
            }
        }

    }

}
