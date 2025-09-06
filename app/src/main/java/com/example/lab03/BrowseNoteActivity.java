package com.example.lab03;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class BrowseNoteActivity extends AppCompatActivity {

    private ProgressBar searchProgressBar;
    private TextView searchResultTextView;
    private Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_note);

        // This is the important part: Find the views by their IDs from the XML file.
        // If the IDs don't match, or the views don't exist, the app will crash here.
        searchProgressBar = findViewById(R.id.search_progress);
        searchResultTextView = findViewById(R.id.search_result_text);
        searchButton = findViewById(R.id.search_button);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show progress bar and hide search result
                searchProgressBar.setVisibility(View.VISIBLE);
                searchResultTextView.setVisibility(View.GONE);
                searchButton.setEnabled(false);

                // Simulate loading data with a new thread
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000); // Delay for 2 seconds
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        // Update UI on the main thread after loading
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                searchProgressBar.setVisibility(View.GONE);
                                searchResultTextView.setVisibility(View.VISIBLE);
                                searchButton.setEnabled(true);
                            }
                        });
                    }
                }).start();
            }
        });
    }
}