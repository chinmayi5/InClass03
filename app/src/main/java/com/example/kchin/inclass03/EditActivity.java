package com.example.kchin.inclass03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String type = (String) intent.getStringExtra(DisplayActivity.NAME_EDIT);

        if(type.equals("mood")) {
            setContentView(R.layout.activity_edit);

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

            Button button = findViewById(R.id.button2);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent response = new Intent();
                    response.putExtra("mood", mood[0]);
                    setResult(RESULT_OK, response);
                    finish();
                }
            });
        }

        else if(type.equals("department")){
            setContentView(R.layout.activity_edit_radio);

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

            Button button = findViewById(R.id.button2);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent response = new Intent();
                    response.putExtra("dept", dept[0]);
                    setResult(RESULT_OK, response);
                    finish();
                }
            });
        }

    }
}
