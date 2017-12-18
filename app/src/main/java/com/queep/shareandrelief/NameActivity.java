package com.queep.shareandrelief;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NameActivity extends AppCompatActivity implements View.OnClickListener {
    DatabaseReference mDatabase;
    String name;
    Toast t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        Button btnYes =  findViewById(R.id.btnYes);
        Button btnNo =  findViewById(R.id.btnNo);
        TextView txt =  findViewById(R.id.editName);
        btnNo.setOnClickListener(this);
        btnYes.setOnClickListener(this);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        name = MainActivity.str.trim();
        txt.setText("Your name is "+name+"! Would you like to send this to firebase?");
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnYes:
                mDatabase.child("Name").setValue(name);
                t = Toast.makeText(getApplicationContext(),"Send To Srver", Toast.LENGTH_SHORT);
                t.show();
                break;
            case R.id.btnNo:
                t = Toast.makeText(getApplicationContext(),"Send To Srver", Toast.LENGTH_SHORT);
                t.show();
                break;
        }
    }
}
