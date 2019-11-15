package com.example.guiexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // references button in xml
        Button button = findViewById(R.id.noTouchButton);

        // references the textview in xml
        TextView textView = findViewById(R.id.outputText);

        // regular onClickListener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // setup of the snackbar
                Snackbar snackbar = Snackbar
                        .make(v, "Cancel self destruct?", Snackbar.LENGTH_INDEFINITE)
                        .setAction("YES CANCEL IT!", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                textView.setText("...Working...");
                            }
                        });

                // changes the text in textview
                textView.setText("I warned you, now i have to  self destruct");

                // creates and shows a toast notification
                Toast.makeText(MainActivity.this,
                        "Selfdestruct initialized!",
                        Toast.LENGTH_LONG).show();

                // displays snackbar that was prepared earlier
                snackbar.show();

            }
        });


    }
}
