package com.example.adaptors;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";  // For logging errors

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            // Create some sample data for the ListView
            ArrayList<String> items = new ArrayList<>();
            items.add("pen");
            items.add("bag");
            items.add("book");
            items.add("tree");

            // Find the ListView by ID
            ListView listView = findViewById(R.id.listView);

            // Check if the ListView was found successfully
            if (listView == null) {
                throw new NullPointerException("ListView not found!");
            }

            // Create an ArrayAdapter to bind the data to the ListView
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.itemText, items);

            // Set the adapter for the ListView
            listView.setAdapter(adapter);

        } catch (NullPointerException e) {
            // Handle case where the ListView is not found
            Log.e(TAG, "Error: " + e.getMessage());
            Toast.makeText(this, "ListView not found!", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            // Catch any other exceptions
            Log.e(TAG, "An error occurred: " + e.getMessage());
            Toast.makeText(this, "An unexpected error occurred!", Toast.LENGTH_SHORT).show();
        }
    }
}
