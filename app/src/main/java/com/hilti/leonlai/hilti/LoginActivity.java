package com.hilti.leonlai.hilti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    //object of helper
    Database helper =new Database(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }



    public void onBtnClick (View v){
        if(v.getId()==R.id.btnLogin){

            EditText a = (EditText)findViewById(R.id.edtLoginUsername);
            String strName = a.getText().toString();

            EditText b = (EditText)findViewById(R.id.edtLoginPassword);
            String strPass= b.getText().toString();

            String password = helper.searchPass(strName);

            if (strPass.equals(password)){
                Intent i =new Intent(LoginActivity.this, product.class);
                i.putExtra("Username",strName);
                startActivity(i);

            }
            else
            {
                Toast pass = Toast.makeText(LoginActivity.this, "Username or Password don't match",Toast.LENGTH_SHORT);
                pass.show();

            }


        }
        if (v.getId() == R.id.btnSignUp){
            Intent i =new Intent(LoginActivity.this, signUp1.class);

            startActivity(i);
        }

    }
}
