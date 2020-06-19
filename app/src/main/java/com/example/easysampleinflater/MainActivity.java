package com.example.easysampleinflater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout root;
    private TextView textView;
    private Button button;
    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (!flag){
                    getLayoutInflater().inflate(R.layout.inflate_layout, root);
                    flag = true;
                }
                else{
                    root.removeAllViews();
                    flag = false;
                }
            }
        });

    }

    private void initialize(){
        root = findViewById(R.id.root);
        textView = findViewById(R.id.text);
        textView.setText(R.string.contents);
        button = findViewById(R.id.button);
    }


}
