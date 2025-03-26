package com.example.ex2;

import android.content.Intent;
import android.graphics.Color;
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

public class ChildActivity extends AppCompatActivity {
    private TextView txt_first_child;
    private TextView txt_second_child;
    private EditText edit_child;
    private Button btnRevised;
    Intent myintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_child);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txt_first_child = findViewById(R.id.txtFirstChild);
        txt_second_child = findViewById(R.id.txtSecondChild);
        edit_child = findViewById(R.id.editChild);
        btnRevised = findViewById(R.id.btnRevised);
        txt_first_child.setTextColor(Color.RED);
        txt_second_child.setTextColor(Color.RED);

                myintent = getIntent();
        String str = myintent.getStringExtra("mypackage");
        edit_child.setText(str);
        btnRevised.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = edit_child.getText().toString();
                myintent.putExtra("Revised", str);
                setResult(33,myintent);
                finish();
            }
        });
    }
}