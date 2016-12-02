package com.hilti.leonlai.hilti;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class product extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_list);
        String username = getIntent().getStringExtra("Username");

        TextView tv = (TextView)findViewById(R.id.txtUsername);
        tv.setText(username); //name of the string

    }
}
