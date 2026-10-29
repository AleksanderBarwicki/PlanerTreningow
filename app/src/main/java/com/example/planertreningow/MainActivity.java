package com.example.planertreningow;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Deklaracja elementów interfejsu
    private ImageView ivExerciseImage;
    private TextView tvExerciseName;
    private TextView tvCurrentSeries;
    private TextView tvTotalSeries;
    private Button btnDrawExercise, btnMinus, btnPlus, btnNextExercise, btnReset;

    private int currentSeriesCount = 0;
    private int totalSeriesCount = 0;
    private Random random;

    private final int[] exerciseImages = {
            R.drawable.cwiczenie0,
            R.drawable.cwiczenie1,
            R.drawable.cwiczenie2,
            R.drawable.cwiczenie3,
            R.drawable.cwiczenie4,
            R.drawable.cwiczenie5,
            R.drawable.cwiczenie6
    };

    private final String[] exerciseNames = {
            "Losuj ćwiczenie",
            "Przysiad",
            "Pompki",
            "Plank",
            "Wykroki",
            "Burpees",
            "Podciąganie"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        random = new Random();
        ivExerciseImage = findViewById(R.id.ivExerciseImage);
        tvExerciseName = findViewById(R.id.tvExerciseName);
        tvCurrentSeries = findViewById(R.id.tvCurrentSeries);
        tvTotalSeries = findViewById(R.id.tvTotalSeries);
        btnDrawExercise = findViewById(R.id.btnDrawExercise);
        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);
        btnNextExercise = findViewById(R.id.btnNextExercise);
        btnReset = findViewById(R.id.btnReset);
        resetToInitialState();
        btnDrawExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawRandomExercise();
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentSeriesCount++;
                tvCurrentSeries.setText(String.valueOf(currentSeriesCount));
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentSeriesCount > 0) {
                    currentSeriesCount--;
                    tvCurrentSeries.setText(String.valueOf(currentSeriesCount));
                }
            }
        });

        btnNextExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalSeriesCount += currentSeriesCount;
                tvTotalSeries.setText("Łączna liczba serii: " + totalSeriesCount);
                drawRandomExercise();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetToInitialState();
            }
        });
    }
    private void resetToInitialState() {
        currentSeriesCount = 0;
        totalSeriesCount = 0;
        tvCurrentSeries.setText(String.valueOf(currentSeriesCount));
        tvTotalSeries.setText("Łączna liczba serii: " + totalSeriesCount);
        ivExerciseImage.setImageResource(exerciseImages[0]);
        tvExerciseName.setText(exerciseNames[0]);
    }

    private void drawRandomExercise() {
        int drawnIndex = random.nextInt(6) + 1;
        ivExerciseImage.setImageResource(exerciseImages[drawnIndex]);
        tvExerciseName.setText(exerciseNames[drawnIndex]);
        currentSeriesCount = 0;
        tvCurrentSeries.setText(String.valueOf(currentSeriesCount));
    }
}