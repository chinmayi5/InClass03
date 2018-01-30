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
    TextView name;
    TextView email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();
        student = (Student) intent.getSerializableExtra(MainActivity.STUDENT_KEY);

        Log.d("Activity3", "Student Received " + student.toString());

        name = findViewById(R.id.DisplayNamebox);
        email = findViewById(R.id.DisplayEmailbox);
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
                String moodNew = data.getStringExtra("mood");
                String deptNew = data.getStringExtra("dept");
                String nameNew = data.getStringExtra("name");
                String emailNew = data.getStringExtra("email");

                Log.d("Activity3", nameNew);

                if(moodNew != null && moodNew.length() != 0) mood.setText(moodNew);
                if(deptNew != null && deptNew.length() != 0) department.setText(deptNew);
                if(nameNew != null && nameNew.length() != 0) name.setText(nameNew);
                if(emailNew != null && emailNew.length() != 0) email.setText(emailNew);
            }
        }

    }

}
