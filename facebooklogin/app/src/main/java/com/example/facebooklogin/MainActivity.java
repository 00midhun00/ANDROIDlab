package com.example.facebooklogin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button likeButton, commentButton, shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize buttons
        likeButton = findViewById(R.id.likeButton);
        commentButton = findViewById(R.id.commentButton);
        shareButton = findViewById(R.id.shareButton);

        // Set up button click listeners
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show toast message when "Like" is clicked
                Toast.makeText(MainActivity.this, "You liked this post!", Toast.LENGTH_SHORT).show();
            }
        });

        commentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show toast message when "Comment" is clicked
                Toast.makeText(MainActivity.this, "You commented on this post!", Toast.LENGTH_SHORT).show();
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show toast message when "Share" is clicked
                Toast.makeText(MainActivity.this, "You shared this post!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
