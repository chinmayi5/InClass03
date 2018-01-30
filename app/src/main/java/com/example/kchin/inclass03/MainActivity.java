//package com.example.kchin.inclass03;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.view.View;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.RadioGroup;
//
//public class MainActivity extends AppCompatActivity {
//
//    public static final String STUDENT_KEY = "student";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        final EditText nameText = findViewById(R.id.nameInput);
//        final EditText emailText = findViewById(R.id.emailInput);
//        final RadioGroup departmentSelection = findViewById(R.id.radioGroup1);
//
//        departmentSelection.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if(checkId == R.id.SISradioButton){
//
//                }
//            }
//        });
//
//
//        Button button = findViewById(R.id.someButton);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String name = nameText.getText().toString();
//                String email = nameText.getText().toString();
//
//                Student student = new Student();
//                student.setDepartment(dept);
//                student.setEmail(email);
//                student.setMood(mood);
//                student.setName(name);
//
//                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
//                intent.putExtra(STUDENT_KEY, student);
//
//            }
//        });
//    }
//}
