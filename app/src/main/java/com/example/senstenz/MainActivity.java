package com.example.senstenz;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    TextView LblValor;
    SensorManager SensorSM;
    Sensor SensorX;

    Canvasjiji LienzoA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LblValor = findViewById(R.id.LblValor);
        SensorSM = (SensorManager) getSystemService(SENSOR_SERVICE);
        SensorX = SensorSM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        Canvasjiji lienzoA = new Canvasjiji(this);
        setContentView(lienzoA);


        if (SensorX == null){
            Toast.makeText(this,"Sensor no existe", Toast.LENGTH_SHORT);
        }else{
            SensorSM.registerListener(this, SensorX, SensorManager.SENSOR_DELAY_FASTEST);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent evento) {
        switch (evento.sensor.getType()){
            case Sensor.TYPE_ACCELEROMETER:
                LblValor.setText("X = " + evento.values[0]
                        + "\nY = " + evento.values[1]
                        + "\nZ = " + evento.values[2]);

                Canvasjiji.XDDD.vx = evento.values[0];
                Canvasjiji.XDDD.vy = evento.values[1];


                Canvasjiji lienzoA = new Canvasjiji(this);
                setContentView(lienzoA);

                break;
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}