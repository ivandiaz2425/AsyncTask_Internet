package com.example.aula7.asynctask_internet;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.id_pb_1);
        button = (Button) findViewById(R.id.id_btn_1);
        textView = (TextView) findViewById(R.id.id_tv_1);
    }

    public Boolean isOnLine (){
        //Connectivity para manejar las actividades
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        // obtener el estado de las conexxion
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();



    }
    public void loadData (View view){



    }
}
