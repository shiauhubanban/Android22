package com.org.iii.shine22;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SensorManager smgr;
    private Sensor sensor;
    private MySensorListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        smgr=(SensorManager)getSystemService(SENSOR_SERVICE);

        List<Sensor> sensors = smgr.getSensorList(Sensor.TYPE_ALL);
        for(Sensor sensor:sensors) {
            Log.v("shine", sensor.getName()+":"+sensor.getType()+":"+sensor.getVendor());
        }
        sensor = smgr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        listener = new MySensorListener();
    }
    private class MySensorListener implements SensorEventListener{
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {}
    }
}
