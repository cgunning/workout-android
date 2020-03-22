package se.gunning.workout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    List<String> workouts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        populateWorkouts(workouts);
        setContentView(R.layout.activity_second);
        LinearLayout rootView = findViewById(R.id.workouts_content);
        populateWorkoutView(rootView);
    }

    private void populateWorkoutView(LinearLayout rootView) {
        int i = 0;
        for (String workout : workouts) {
            LinearLayout row = new LinearLayout(this);
            row.setOrientation(LinearLayout.HORIZONTAL);
            row.setClickable(true);
            row.setOnClickListener(this);
            row.setPadding(20, 40, 20, 40);
            if (i%2 == 0) {
                row.setBackgroundColor(Color.LTGRAY);
            }
            TextView text1 = new TextView(this);
            text1.setText(workout);
            text1.setTextSize(20);
            text1.setClickable(false);
            row.addView(text1);
            row.setTag(workout);
            row.setId(i);
            rootView.addView(row);
            i++;
        }
    }


    private void populateWorkouts(List<String> workouts) {
        for (int i = 1; i < 20; i++) {
            workouts.add("Workout " + i);
        }
    }

    public void startHelloActivity(View view) {
        Intent intent = new Intent(SecondActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        LinearLayout row = findViewById(v.getId());
        Toast.makeText(this, "You picked " + row.getTag(), Toast.LENGTH_LONG).show();
    }
}
