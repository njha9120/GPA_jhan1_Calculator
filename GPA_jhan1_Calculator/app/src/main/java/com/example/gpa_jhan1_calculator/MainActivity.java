package com.example.gpa_jhan1_calculator;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button, TextView, textview7, EditText ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText grade1 = findViewById(R.id.editTextNumber);
        final EditText grade2 = findViewById(R.id.editTextNumber2);
        final EditText grade3 = findViewById(R.id.editTextNumber3);
        final EditText grade4 = findViewById(R.id.editTextNumber4);
        final EditText grade5 = findViewById(R.id.editTextNumber5);
        Button calculateButton = findViewById(R.id.button);
        final TextView gpaResult = findViewById(R.id.textview7);
        final ConstraintLayout backgroundLayout = findViewById(R.id.mainLayot); // Assuming your root layout has the id mainLayout

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double gpa = calculateGPA(new EditText[]{grade1, grade2, grade3, grade4, grade5});
                gpaResult.setText(String.format("Your GPA is: %.2f", gpa));
                changeBackgroundColor(gpa, backgroundLayout);
                calculateButton.setText("Clear Form");
            }
        });
    }

    private double calculateGPA(EditText[] grades) {
        double sum = 0;
        for (EditText grade : grades) {
            double value = Double.parseDouble(grade.getText().toString());
            sum += getGradePoint(value);
        }
        return sum / grades.length;
    }

    private double getGradePoint(double grade) {
        if (grade >= 90) return grade;
        if (grade >= 80) return grade;
        if (grade >= 70) return grade;
        if (grade >= 60) return grade;
        return 0.0;
    }

    private void changeBackgroundColor(double gpa, ConstraintLayout layout) {
        if (gpa >= 80.0) { // Equivalent to 80-100
            layout.setBackgroundColor(Color.GREEN);
        } else if (gpa >= 61.0 && gpa < 79.0) { // Equivalent to 61-79
            layout.setBackgroundColor(Color.YELLOW);
        } else { // Less than 60
            layout.setBackgroundColor(Color.RED);
        }
    }
    protected void onResume() {
        super.onResume();

        button.setText("Compute GPA");
        textview7.setBackgroundColor(getResources().getColor(android.R.color.transparent));
    }
}