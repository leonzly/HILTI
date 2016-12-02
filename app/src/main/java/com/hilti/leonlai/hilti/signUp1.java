package com.hilti.leonlai.hilti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class signUp1 extends AppCompatActivity {
   // Database helper =new Database(this);
    Database DBhelper= new Database(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up1);
    }
    public void onBtnSubmitClick(View v) {

        if (v.getId() == R.id.btnSignUpSubmit) {

            EditText name = (EditText) findViewById(R.id.edtSignUpUsername);
            EditText password = (EditText) findViewById(R.id.edtSignUpPassword);
            EditText confirmPassword = (EditText) findViewById(R.id.edtSignUpCfmPwd);

            String nameStr = name.getText().toString();
            String passStr = password.getText().toString();
            String cPassStr = confirmPassword.getText().toString();



             if (nameStr.matches("") || passStr.matches("") || cPassStr.matches("")){
                Toast pass = Toast.makeText(signUp1.this, "Please fill in all the field", Toast.LENGTH_SHORT);
                pass.show();
            }else if (!passStr.equals(cPassStr)) {
                //popup message

                Toast pass = Toast.makeText(signUp1.this, "Password don't match", Toast.LENGTH_SHORT);
                pass.show();
            }

            else {
                //insert the details in db
                Contact c = new Contact();
                c.setName(nameStr);
                c.setPassword(passStr);

                DBhelper.insertContact(c);

                Toast SignUp = Toast.makeText(signUp1.this, "Submit Successful", Toast.LENGTH_SHORT);
                SignUp.show();

                if (c != null) {
                    Intent i = new Intent(signUp1.this, LoginActivity.class);
                    startActivity(i);
                }

            }
        }
    }}
