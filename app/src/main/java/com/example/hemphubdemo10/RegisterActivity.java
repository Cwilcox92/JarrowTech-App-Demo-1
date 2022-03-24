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

public class RegisterActivity extends AppCompatActivity {


    DatabaseHelper db;
    EditText mTextEmail;
    EditText mTextUsername;
    EditText mTextPassword;
    EditText mTextCnfPassword;
    EditText mTextCompanyName;
    Button mButtonRegister;
    TextView mTextViewRegister;
    String strEmail;
    String strUsername;
    String strPassword;
    String strCnfPassword;
    String strCompany;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new DatabaseHelper(this);
        mTextEmail = (EditText) findViewById(R.id.edittext_email);
        mTextUsername = (EditText) findViewById(R.id.edittext_username);
        mTextPassword = (EditText) findViewById(R.id.edittext_password);
        mTextCnfPassword = (EditText) findViewById(R.id.edittext_cnf_password);
        mTextCompanyName = (EditText) findViewById(R.id.edittext_company_name);
        strUsername = mTextUsername.getText().toString();
        strPassword = mTextPassword.getText().toString();
        strCnfPassword = mTextCnfPassword.getText().toString();
        strCompany = mTextCompanyName.getText().toString();
        mButtonRegister = (Button) findViewById(R.id.button_login_register);
        mTextViewRegister = (TextView) findViewById(R.id.textview_login);

        mTextPassword.addTextChangedListener(loginTextWatcher);
        mTextUsername.addTextChangedListener(loginTextWatcher);

        mTextViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent CompanyIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(CompanyIntent);
            }
        });

        mButtonRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText().toString().trim();
                String pswd = mTextPassword.getText().toString().trim();
                String cnf_pswd = mTextCnfPassword.getText().toString().trim();
                if (pswd.equals(cnf_pswd)) {
                    long val = db.addUser(user, pswd);
                    if (val > 0) {
                        Intent moveToCompany = new Intent(RegisterActivity.this, CompanyActivity.class);
                        startActivity(moveToCompany);
                    } else {
                        Toast.makeText(RegisterActivity.this, "Registration Error.", Toast.LENGTH_SHORT).show();


                    }


                } else {
                    Toast.makeText(RegisterActivity.this, "Passwords do not match.", Toast.LENGTH_SHORT).show();


                }


            }
        });


    }



    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            strUsername = mTextUsername.getText().toString().trim();
            strPassword = mTextPassword.getText().toString().trim();

            mButtonRegister.setEnabled(!strUsername.isEmpty() && !strPassword.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };


}
