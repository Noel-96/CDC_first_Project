package com.noel201296gmail.cdcfirsstproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    Button mEnter;
    EditText mBestField;
    EditText mNameField;
    TextView mEmptyError;
    TextView mNoError;
    String sBestField;
    String sNameField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         mEnter= (Button) findViewById(R.id.EnterButton);
         mBestField = (EditText) findViewById(R.id.BestThingField);
         mNameField = (EditText) findViewById(R.id.NameField);
         mEmptyError = (TextView) findViewById(R.id.EmptyFieldError);
         mNoError= (TextView) findViewById(R.id.NoErrorField);

         sBestField = mBestField.getText().toString();
         sNameField= mNameField.getText().toString();



             mNameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                if (TextUtils.isDigitsOnly(mNameField.getText())){
                    mNoError.setVisibility(View.VISIBLE);
                    }
                    else if(isNumeric(sNameField)){
                    mNoError.setVisibility(View.VISIBLE);
                }
                    else {
                      mNoError.setVisibility(View.INVISIBLE);
                    }

            }

            @Override
            public void afterTextChanged(Editable editable) {


            }
        });



        mEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(mNameField.getText()) || TextUtils.isEmpty(mBestField.getText())  ){
                    mEmptyError.setVisibility(View.VISIBLE);
                }
           else {
               Intent myIntent = new Intent(MainActivity.this, ResultActivity.class);
               startActivity(myIntent);
           }


            }
        });



    }

    public static boolean isNumeric(String str)
    {
        return str.matches("-?\\d+(.\\d+)?");
    }
}