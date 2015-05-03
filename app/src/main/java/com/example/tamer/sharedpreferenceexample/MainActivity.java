package com.example.tamer.sharedpreferenceexample;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText usernameTextView;
    EditText passwordTextView;
    TextView dataView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameTextView = (EditText) findViewById(R.id.usernameTextView);
        passwordTextView = (EditText) findViewById(R.id.passwordTextView);
        dataView = (TextView) findViewById(R.id.dataView);
    }

    public void saveButtonClicked(View View) {
        //this code will create a private secure file called userInfo, and put the data into it,
        //in a key value pair using putString method, it's exactly like username = whatever written on username text field,
        //and password = whatever password is made in the password text field
        SharedPreferences mSharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.putString("username", usernameTextView.getText().toString());
        mEditor.putString("password", passwordTextView.getText().toString());
        if (mEditor.commit()) {
            Toast.makeText(this, "Data Saved Successfully!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Data Not Saved!", Toast.LENGTH_LONG).show();
        }
    }

    public void displayButtonClicked(View view) {
        SharedPreferences mSharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        String userName = mSharedPreferences.getString("username", "No Data Found!");
        String passWord = mSharedPreferences.getString("password", "No Data Found!");

        dataView.setText(userName + " " + passWord);

    }


}
