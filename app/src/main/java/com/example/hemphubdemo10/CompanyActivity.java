package com.example.hemphubdemo10;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CompanyActivity extends AppCompatActivity {
    Button mButtonFinishRegistration;
    EditText mTextState;
    EditText mTextCity;
    EditText mTextZipCode;
    String strState;
    String strCity;
    String strZipCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);


        mTextState= (EditText) findViewById(R.id.edittext_state);
        mTextCity= (EditText) findViewById(R.id.edittext_city);
        mTextZipCode= (EditText) findViewById(R.id.edittext_zipcode);
        mButtonFinishRegistration= (Button) findViewById(R.id.button_finish_registration);
        mTextState.addTextChangedListener(loginTextWatcher);
        mTextCity.addTextChangedListener(loginTextWatcher);

        mButtonFinishRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CompanyActivity.this, "You have successfully registered.", Toast.LENGTH_SHORT).show();
                Intent LoginIntent = new Intent(CompanyActivity.this, LoginActivity.class);
                startActivity(LoginIntent);
            }
        });

    }

    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            strState = mTextState.getText().toString().trim();
            strCity = mTextCity.getText().toString().trim();

            mButtonFinishRegistration.setEnabled(!strState.isEmpty() && !strCity.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}

