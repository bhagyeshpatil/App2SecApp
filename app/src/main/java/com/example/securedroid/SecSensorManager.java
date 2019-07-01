package com.example.securedroid;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Handler;

import java.util.List;

import static android.content.Context.SENSOR_SERVICE;

public class SecSensorManager {
    DBHelper myDb;
    Context context;
    SensorManager sm;

    public SecSensorManager(){
    }

    public SecSensorManager(Context context){
        sm = (SensorManager) context.getSystemService(SENSOR_SERVICE);
        this.context = context;
    }

    public Sensor getDefaultSensor (int type){
        myDb = new DBHelper(context);
        myDb.insertPermission("Sensor");

        return sm.getDefaultSensor(type);
    }

    public Sensor getDefaultSensor (int type,
                                    boolean wakeUp){
        myDb = new DBHelper(context);
        myDb.insertPermission("Sensor");

        return  sm.getDefaultSensor(type,  wakeUp);
    }

    public List<Sensor> getDynamicSensorList (int type){
        myDb = new DBHelper(context);
        myDb.insertPermission("Sensor");

        return getDynamicSensorList(type);
    }

    public List<Sensor> getSensorList (int type){
        myDb = new DBHelper(context);
        myDb.insertPermission("Sensor");

        return  sm.getSensorList(type);
    }

    public void registerDynamicSensorCallback (SensorManager.DynamicSensorCallback callback){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            sm.registerDynamicSensorCallback(callback);
        }
    }

    public void registerDynamicSensorCallback (SensorManager.DynamicSensorCallback callback,
                                               Handler handler){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            sm.registerDynamicSensorCallback(callback,handler);
        }
    }

    public boolean registerListener (SensorEventListener listener,
                                     Sensor sensor,
                                     int samplingPeriodUs){
        return sm.registerListener(listener, sensor, samplingPeriodUs);
    }

    public boolean registerListener (SensorEventListener listener,
                                     Sensor sensor,
                                     int samplingPeriodUs,
                                     int maxReportLatencyUs){
        return sm.registerListener(listener, sensor, samplingPeriodUs, maxReportLatencyUs);
    }

    public boolean registerListener (SensorEventListener listener,
                                     Sensor sensor,
                                     int samplingPeriodUs,
                                     Handler handler){
        return sm.registerListener(listener, sensor, samplingPeriodUs, handler);
    }

    public boolean registerListener (SensorEventListener listener,
                                     Sensor sensor,
                                     int samplingPeriodUs,
                                     int maxReportLatencyUs,
                                     Handler handler){
        return sm.registerListener(listener, sensor, samplingPeriodUs, maxReportLatencyUs, handler);
    }

    public void unregisterListener (SensorEventListener listener){
        sm.unregisterListener(listener);
    }

    public void unregisterListener (SensorEventListener listener,
                                    Sensor sensor){
        sm.unregisterListener(listener, sensor);
    }

}
