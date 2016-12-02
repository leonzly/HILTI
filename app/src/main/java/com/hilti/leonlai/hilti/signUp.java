package com.hilti.leonlai.hilti;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by leonlai on 27-Nov-16.
 */

public class signUp extends Activity {
    Database DBhelper= new Database(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

    }

   /* public void onBtnSubmitClick(View v){
        if(v.getId()==R.id.btnSignUpSubmit){
            EditText name=(EditText)findViewById(R.id.edtSignUpUsername);
            EditText password=(EditText)findViewById(R.id.edtSignUpPassword);
            EditText confirmPassword=(EditText)findViewById(R.id.edtSignUpCfmPwd);

            String nameStr = name .getText().toString();
            String passStr = password.getText().toString();
            String cPassStr = confirmPassword.getText().toString();

            if (!passStr.equals(cPassStr)){
                //popup message

                Toast pass = Toast.makeText(signUp.this, "Password don't match",Toast.LENGTH_SHORT);
                pass.show();
            }
            else
            {
                //insert the details in db
                Contact c =new Contact();
                c.setName(nameStr);
                c.setPassword(passStr);

                DBhelper.insertContact(c);

                Toast SignUp = Toast.makeText(signUp.this, "Submit Successful",Toast.LENGTH_SHORT);
                SignUp.show();

            }
        }
    }*/


}
