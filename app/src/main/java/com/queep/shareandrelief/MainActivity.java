package com.queep.shareandrelief;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static String str;
    EditText txtName;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnAdd =  findViewById(R.id.buttonClick);
        txtName =  findViewById(R.id.textName);
        btnAdd.setOnClickListener(this);

    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonClick:
                str = txtName.getText().toString();
                intent = new Intent(MainActivity.this, StartActivity.class);
                break;
        }
        startActivity(intent);
    }
}

