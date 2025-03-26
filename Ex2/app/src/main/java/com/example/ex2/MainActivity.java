package com.example.ex2;

import android.app.ComponentCaller;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    private TextView txt_first;
    private TextView txt_second;
    private TextView txt_third;
    private EditText edit_first;

    private EditText edit_second;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txt_first = findViewById(R.id.txtFirst);
        txt_second = findViewById(R.id.txtSecond);
        txt_third = findViewById(R.id.txtThird);
        edit_first = findViewById(R.id.editFirst);
        edit_second = findViewById(R.id.editSecond);
        btnSubmit = findViewById(R.id.button);
        txt_first.setTextColor(Color.RED);
        txt_second.setTextColor(Color.RED);
        txt_third.setTextColor(Color.RED);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent my_intent = new Intent(MainActivity.this,ChildActivity.class);
                String str = edit_first.getText().toString();
                my_intent.putExtra("mypackage", str);
                startActivityForResult(my_intent, 99);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data, @NonNull ComponentCaller caller) {
        super.onActivityResult(requestCode, resultCode, data, caller);
        if (requestCode == 99 && resultCode == 33)
        {
            String str = data.getStringExtra("Revised");
            edit_second.setText(str);
        }
    }
}