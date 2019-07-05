package com.developer.demoretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    private DataClient dataClient;
    private EditText name;
    private EditText job;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login2);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        name = (EditText) findViewById(R.id.name);
        job = (EditText) findViewById(R.id.job);
        button = findViewById(R.id.btn);
        createUser();
        //login();


    }

    private void createUser() {

       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               dataClient = APIUtils.getData();
               final User user = new User("morpheus", "leader");
               dataClient.createUser(user).enqueue(new Callback<User>() {
                                                       @Override
                                                       public void onResponse(Call<User> call, Response<User> response) {
                                                           if (!response.isSuccessful()) {
                                                               Log.e("Code:", response + "");
                                                               return;
                                                           }
                                                           User user1 = response.body();
                                                           if (user1 != null) {
                                                               Log.e("Name", user.getName());
                                                               Log.e("Job", user.getJob());
                                                               Log.e("id", user.getId() + "");
                                                               Log.e("createdAt", user.getCreatedAt() + "");
                                                               Log.e("Code:", response.code() + "");


                                                           }
                                                       }

                                                       @Override
                                                       public void onFailure(Call<User> call, Throwable t) {
                                                           Toast.makeText(Login.this, "Fail", Toast.LENGTH_SHORT).show();

                                                       }
                                                   }
               );
           }
       });


    }

    private void login() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataClient = APIUtils.getData();
                final String tonken_api = "QpwL5tke4Pnpja7X4";
                dataClient.login("eve.holt@reqres.in", "cityslicka").enqueue(new Callback<LoginUser>() {
                                                                                 @Override
                                                                                 public void onResponse(Call<LoginUser> call, Response<LoginUser> response) {

                                                                                     if (!response.isSuccessful()) {
                                                                                         Log.e("Code", response.body().getToken() + "");
//
                                                                                         return;
                                                                                     }
                                                                                     String tooken = response.body().getToken();
                                                                                     if (tooken != null) {
                                                                                         if (tooken.equals(tonken_api)) {


                                                                                             startActivity(new Intent(Login.this, MainActivity.class));


                                                                                         }
                                                                                     }


                                                                                 }

                                                                                 @Override
                                                                                 public void onFailure(Call<LoginUser> call, Throwable t) {
                                                                                     Toast.makeText(Login.this, "Khong ton tai tai khoan nay" + t.getMessage(), Toast.LENGTH_SHORT).show();

                                                                                 }
                                                                             }
                );
            }
        });
    }

}
