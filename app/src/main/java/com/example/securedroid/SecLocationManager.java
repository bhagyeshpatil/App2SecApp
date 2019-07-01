package com.example.securedroid;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Looper;

import java.util.List;

import static android.content.Context.LOCATION_SERVICE;

//For Location
public class SecLocationManager {
    DBHelper myDb;
    Context context;
    LocationManager lm;

    public SecLocationManager() {
    }

    public SecLocationManager(Context context) {
        lm = (LocationManager) context.getSystemService(LOCATION_SERVICE);
        this.context = context;
    }

    public Boolean isProviderEnabled(String provider){
        return lm.isProviderEnabled(provider);
    }

    @SuppressLint("MissingPermission")
    public Location getLastKnownLocation(String provider){

        myDb = new DBHelper(context);
        myDb.insertPermission("Location");

        return lm.getLastKnownLocation(provider);
    }

    @SuppressLint("MissingPermission")
    public void requestLocationUpdates(String provider, long minTime, float minDistance, LocationListener listener){
        lm.requestLocationUpdates(provider, minTime, minDistance, listener);
    }

    @SuppressLint("MissingPermission")
    public void requestLocationUpdates(long minTime, float minDistance, Criteria criteria, LocationListener listener, Looper looper){
        lm.requestLocationUpdates(minTime, minDistance, criteria, listener, looper);
    }

    @SuppressLint("MissingPermission")
    public void requestLocationUpdates(long minTime, float minDistance, Criteria criteria, PendingIntent intent){
        lm.requestLocationUpdates(minTime, minDistance, criteria, intent);
    }

    @SuppressLint("MissingPermission")
    public void requestLocationUpdates(String provider, long minTime, float minDistance, LocationListener listener, Looper looper){
        lm.requestLocationUpdates(provider, minTime, minDistance, listener, looper);
    }

    @SuppressLint("MissingPermission")
    public void requestLocationUpdates(String provider, long minTime, float minDistance, PendingIntent intent){
        lm.requestLocationUpdates(provider, minTime, minDistance, intent);
    }

    public List<String> getProviders (Criteria criteria, boolean enabledOnly){
        return lm.getProviders(criteria,enabledOnly);
    }

    public List<String> getProviders (boolean enabledOnly){
        return lm.getProviders(enabledOnly);
    }

}
