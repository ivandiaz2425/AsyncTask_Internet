package com.example.aula7.asynctask_internet;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

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
        //Connectivity para manejar las actividades.....
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        // obtener el estado de las conexxion....+
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        //validar estado de la red...
        if (networkInfo != null){
            return true;
        }else{
            return false;
        }
    }
    public void loadData (View view){

        if (isOnLine()){

            //Toast.makeText(this, "Cargar Datos", Toast.LENGTH_SHORT).show();
            MyTask task = new MyTask();
            task.execute();

        }else{

            Toast.makeText(this, "Sin Conexion ", Toast.LENGTH_SHORT).show();
        }
    }
    public void processData(String s){

        textView.append("Item: "+s + "\n");
        //textView.setTextSize(Integer.parseInt(s));

    }

    public class MyTask extends AsyncTask<String, String, String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);

        }

        @Override
        protected String doInBackground(String... strings) {
            for (int i=1; i < 50; i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(String.valueOf(i));
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);

            processData(values[0]);


        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressBar.setVisibility(View.GONE);

        }
    }

}
