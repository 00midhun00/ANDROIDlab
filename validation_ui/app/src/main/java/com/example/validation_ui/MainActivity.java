package com.example.validation_ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity  extends AppCompatActivity {
    EditText Name,Email,Password,Phone,Dob,cassword;
    RadioGroup gender;
    CheckBox hobby;
    Button submit;
    Spinner country;

    @SuppressLint("MissingInflatedId")
    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.name);
        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        cassword = findViewById(R.id.cassword);

        gender = findViewById(R.id.gender);
        country = findViewById(R.id.scountry);
        Phone = findViewById(R.id.Phone);
        Dob = findViewById(R.id.dob);
        hobby = findViewById(R.id.hobby);
        submit = findViewById(R.id.submit);
        String[] countries = {"select country","india","usa","uk","australia"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, countries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        country.setAdapter(adapter);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });


    }

    private void validate(){
        String name = Name.getText().toString().trim();
        String email = Email.getText().toString().trim();
        String password = Password.getText().toString().trim();
        String phone = Phone.getText().toString().trim();
        String dob = Dob.getText().toString().trim();
        String cpassword = cassword.getText().toString();
        String scountry = country.getSelectedItem().toString();

        if (TextUtils.isEmpty(name)){
            Name.setError("Please enter your name");
            return;
        }
        if(TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Email.setError("enter a valid email");
            return;
        }

        if(password.length() < 6) {
            Password.setError("password must be at least 6 char");
            return;
        }

        if(gender.getCheckedRadioButtonId() == -1){
            Toast.makeText(this, "please select gender", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!hobby.isChecked()) {
            Toast.makeText(this, "please select yor hobby", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!password.equals(cpassword)) {
            cassword.setError("Passwords do not match");
            return;
        }
        if (TextUtils.isEmpty(dob) || !dob.matches("\\d{2}/\\d{2}/\\d{4}")) {
            Dob.setError("Enter DOB in dd/mm/yyyy format");
            return;
        }
        if (TextUtils.isEmpty(phone) || phone.length() != 10) {
            Phone.setError("Enter a valid 10-digit phone number");
            return;
        }
        if (scountry.equals("Select Country")) {
            Toast.makeText(this, "Please select a country", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "All inputs are valid", Toast.LENGTH_SHORT).show();
    }
}