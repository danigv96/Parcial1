package com.example.estudiante.parcial1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button btn_enviar;
    private Cliente c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c = new Cliente(this);
        c.start();

        btn_enviar = findViewById(R.id.btn_enviar);
        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c.enviar();

            }
        });
    }

    public void onReceived (final String mensaje){

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this,mensaje, Toast.LENGTH_LONG).show();
            }
        });
    }
}
