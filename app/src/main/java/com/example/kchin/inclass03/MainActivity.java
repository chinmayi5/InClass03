package com.example.kchin.inclass03;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String STUDENT_KEY = "student";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText nameText = findViewById(R.id.nameInput);
        final EditText emailText = findViewById(R.id.emailInput);
        final RadioGroup departmentSelection = findViewById(R.id.radioGroup1);
        final String[] dept = new String[1];

        departmentSelection.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.SISradioButton){
                    dept[0] = "SIS";
                } else if(checkedId == R.id.CSradioButton){
                    dept[0] = "CS";
                } else if(checkedId == R.id.BIOradioButton){
                    dept[0] = "BIO";
                } else {
                    dept[0] = "Other";
                }
            }
        });

        final SeekBar seek = findViewById(R.id.seekBar);
        final String[] mood = new String[1];
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mood[0] = (progress + "% Positive");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        Button button = findViewById(R.id.submitButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nameText.getText().toString();
                String email = nameText.getText().toString();

                Student student = new Student();
                student.setDepartment(dept[0]);
                student.setEmail(email);
                student.setMood(mood[0]);
                student.setName(name);

                Log.d("Activity3", "Printing Student: " + student.toString());

                if(hasMissingData(student)){
                    Toast toast = Toast.makeText(MainActivity.this, "Sorry but you are missing data!", Toast.LENGTH_LONG);
                }

                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                intent.putExtra(STUDENT_KEY, student);

            }
        });
    }

    protected boolean hasMissingData(Student student){
        if(student.getDepartment() == ""){
            return true;
        } else if(student.getEmail() == ""){
            return true;
        } else if(student.getMood() == ""){
            return true;
        } else if(student.getName() == ""){
            return true;
        } else {
            return false;
        }
    }

}
