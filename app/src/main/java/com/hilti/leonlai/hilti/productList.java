package com.hilti.leonlai.hilti;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by leonlai on 27-Nov-16.
 */

public class productList extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_list);
        String username = getIntent().getStringExtra("Username");

        TextView tv = (TextView)findViewById(R.id.txtUsername);
        tv.setText(username); //name of the string

    }
}
