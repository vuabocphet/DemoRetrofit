package com.developer.demoretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
private DataClient dataClient;
private RecyclerView recyclerView;
private AdapterView adapterView;
@SuppressLint("WrongConstant")
private LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.layout);
        dataClient=APIUtils.getData();
        setProgressBarIndeterminate(true);
        dataClient.getAll().enqueue(new Callback<Question>() {
            @Override
            public void onResponse(Call<Question> call, Response<Question> response) {
                Toast.makeText(MainActivity.this, "Oki", Toast.LENGTH_SHORT).show();
                Question question=response.body();
                List<Datum> data=question.getData();
                adapterView=new AdapterView(MainActivity.this,data);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(adapterView);
                Log.e("SIZE",data.size()+"");
                setProgressBarIndeterminate(false);
            }

            @Override
            public void onFailure(Call<Question> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Fail"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void click(Datum datum){
        Intent intent=new Intent(this,Edit.class);
        intent.putExtra("listData",datum);
        startActivity(intent);
    }
}
