package com.example.lab03;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Date;

public class AddNoteActivity extends AppCompatActivity {

    Button submitTextNote;
    EditText titleOfTextNote,contentOfTextNote;
    TextView showNote;
    User currentUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_note);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        submitTextNote = findViewById(R.id.button4);
        titleOfTextNote = findViewById(R.id.WriteText1);
        contentOfTextNote = findViewById(R.id.WriteText2);
        showNote = findViewById(R.id.textView3);

        currentUser = new User("Sukrit Taing", "sukrit.t@email.com");

        submitTextNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strOfTitle = titleOfTextNote.getText().toString();
                String strOfContent = contentOfTextNote.getText().toString();
                String strOfDate = new Date().toString();

                TextNote textNote1 = new TextNote(strOfTitle, strOfContent);
                textNote1.setTextContent(strOfContent);

                String noteDisplay = currentUser.displayUser() + "\n\n" + textNote1.display();
                showNote.setText(noteDisplay);
            }
        });
    }
}