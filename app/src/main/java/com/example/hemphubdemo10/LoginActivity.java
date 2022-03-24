package com.example.hemphubdemo10;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonLogin;
    TextView mTextViewRegister;
    DatabaseHelper db;
    String lstrUsername;
    String lstrPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db= new DatabaseHelper(this);
        mTextUsername= (EditText) findViewById(R.id.edittext_username);
        mTextPassword= (EditText) findViewById(R.id.edittext_password);
        mButtonLogin= (Button) findViewById(R.id.button_login);
        mTextViewRegister= (TextView) findViewById(R.id.textview_register);
        mTextPassword.addTextChangedListener(loginTextWatcher);
        mTextUsername.addTextChangedListener(loginTextWatcher);


        mTextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent= new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(registerIntent);

            }
        });


        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText().toString().trim();
                String pswd = mTextPassword.getText().toString().trim();

                Boolean res = db.checkUser(user,pswd);
                if(res == true)
                {
                    Toast.makeText(LoginActivity.this,"Successfully Logged In", Toast.LENGTH_SHORT).show();
                    Intent LoginScreen = new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(LoginScreen);

                }
                else {
                    Toast.makeText(LoginActivity.this,"Account Not Registered", Toast.LENGTH_SHORT).show();


                }


            }
        });



    }

    public void OnLogin(View view)
    {   String user = mTextUsername.getText().toString().trim();
        String pswd = mTextPassword.getText().toString().trim();
        String type= "login";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,user,pswd);

    }

    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            lstrUsername = mTextUsername.getText().toString().trim();
            lstrPassword = mTextPassword.getText().toString().trim();

            mButtonLogin.setEnabled(!lstrUsername.isEmpty() && !lstrPassword.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}
