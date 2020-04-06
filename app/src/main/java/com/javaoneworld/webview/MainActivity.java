package com.javaoneworld.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnLoadUrl;
    private TextView txtUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLoadUrl = findViewById(R.id.btnLoadUrl);
        txtUrl = findViewById(R.id.txtViewUrl);

        btnLoadUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,WebViewActivity.class);
                intent.putExtra("URL", txtUrl.getText().toString());
                startActivity(intent);
            }
        });
    }
}
