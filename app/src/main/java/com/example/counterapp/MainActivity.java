package com.example.counterapp;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView counterTextView;
    private Button startButton;
    private Button stopButton;

    private Handler handler = new Handler();
    private int counter = 0;
    private boolean isCounting = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterTextView = findViewById(R.id.counterTextView);
        startButton = findViewById(R.id.startButton);
        stopButton = findViewById(R.id.stopButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCounting();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopCounting();
            }
        });
    }

    private void startCounting() {
        if (!isCounting) {
            isCounting = true;
            handler.postDelayed(counterRunnable, 1000);
        }
    }

    private void stopCounting() {
        if (isCounting) {
            isCounting = false;
            handler.removeCallbacks(counterRunnable);
        }
    }

    private Runnable counterRunnable = new Runnable() {
        @Override
        public void run() {
            counter++;
            counterTextView.setText(String.valueOf(counter));
            handler.postDelayed(this, 1000);
        }
    };
}
