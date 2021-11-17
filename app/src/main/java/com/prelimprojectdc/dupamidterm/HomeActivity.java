package com.prelimprojectdc.dupamidterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class HomeActivity extends AppCompatActivity {

    EditText lastName, firstName, accountName, init_invest, remarks;
    EditText start_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        lastName = findViewById(R.id.lastName);
        firstName = findViewById(R.id.firstName);
        accountName = findViewById(R.id.accountName);
        init_invest = findViewById(R.id.init_invest);
        start_date = findViewById(start_date.getId());
        remarks = findViewById(R.id.remarks);
    }
}