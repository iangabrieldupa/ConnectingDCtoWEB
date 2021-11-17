package com.prelimprojectdc.dupamidterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.prelimprojectdc.dupamidterm.api.RequestPlaceholder;
import com.prelimprojectdc.dupamidterm.api.RetrofitBuilder;
import com.prelimprojectdc.dupamidterm.pojos.Login;
import com.google.android.material.button.MaterialButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    
    public EditText username, password;
    public Button signinBtn;
    public RetrofitBuilder retrofitBuilder;
    public RequestPlaceholder requestPlaceholder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        signinBtn = findViewById(R.id.signinBtn);

        retrofitBuilder = new RetrofitBuilder();
        requestPlaceholder = retrofitBuilder.getRetrofit().create(RequestPlaceholder.class);
        signinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText() !=null && password.getText() !=null){
                    Call<Login> loginCall = requestPlaceholder.login(new Login(null, username.getText().toString(), null, null,password.getText().toString()));

                    loginCall.enqueue(new Callback<Login>() {
                        @Override
                        public void onResponse(Call<Login> call, Response<Login> response) {
                            if (!response.isSuccessful()){
                                if (response.code() == 404) {
                                    Toast.makeText(MainActivity.this, "User Not Found", Toast.LENGTH_SHORT).show();
                                    Log.e("LOGGING_ERR", response.message());

                                }
                            }else{
                                if (response.code() == 200){
                                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<Login> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "Error Logging In", Toast.LENGTH_SHORT).show();
                            Log.e("LOGGING_ERR", t.getMessage());
                        }
                    });
                }else {
                    Toast.makeText(MainActivity.this, "All Fields are Required!", Toast.LENGTH_SHORT).show();
                }
                }
                });


    }
}