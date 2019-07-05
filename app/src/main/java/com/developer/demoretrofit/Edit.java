package com.developer.demoretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Edit extends AppCompatActivity {
    private Datum datum = null;
    private EditText mail;
    private EditText lastName;
    private Button btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        Intent intent = getIntent();
        mail =(EditText)

                findViewById(R.id.mail);

        lastName =(EditText)

                findViewById(R.id.last_name);

        btn =(Button)

                findViewById(R.id.btn);

        if (intent != null) {
            datum = (Datum) intent.getSerializableExtra("listData");
            if (datum != null) {
            mail.setText(datum.getEmail());
            //lastName.se tText(datum.getLastName());

            }

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }
}
