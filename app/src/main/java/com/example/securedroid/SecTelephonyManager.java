package com.example.securedroid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;

import java.util.List;

//For Read_Phone_State
public class SecTelephonyManager {

    DBHelper myDb;
    Context context;
    TelephonyManager tMgr;

    public SecTelephonyManager(){
    }

    public SecTelephonyManager(Context context){
        tMgr = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        this.context = context;
    }

    @SuppressLint("MissingPermission")
    public List<CellInfo> getAllCellInfo (){
        myDb = new DBHelper(context);
        myDb.insertPermission("READ_PHONE_STATE");

        return tMgr.getAllCellInfo();
    }

    public int getCallState (){
        myDb = new DBHelper(context);
        myDb.insertPermission("READ_PHONE_STATE");

        return tMgr.getCallState();
    }

    @SuppressLint("MissingPermission")
    public CellLocation getCellLocation (){
        myDb = new DBHelper(context);
        myDb.insertPermission("READ_PHONE_STATE");
        myDb.insertPermission("Location");

        return tMgr.getCellLocation();
    }

    @SuppressLint("MissingPermission")
    public String getDeviceId (int slotIndex){
        myDb = new DBHelper(context);
        myDb.insertPermission("READ_PHONE_STATE");

        return tMgr.getDeviceId(slotIndex);
    }

    @SuppressLint({"MissingPermission", "NewApi"})
    public String getImei (int slotIndex){
        myDb = new DBHelper(context);
        myDb.insertPermission("READ_PHONE_STATE");

        return tMgr.getImei(slotIndex);

    }

    @SuppressLint({"MissingPermission", "NewApi"})
    public String getImei (){
        myDb = new DBHelper(context);
        myDb.insertPermission("READ_PHONE_STATE");

        return tMgr.getImei();

    }

    @SuppressLint("MissingPermission")
    public String getLine1Number (){
        myDb = new DBHelper(context);
        myDb.insertPermission("READ_PHONE_STATE");

        return tMgr.getLine1Number();
    }

    @SuppressLint("MissingPermission")
    public String getNetworkOperator (){
        myDb = new DBHelper(context);
        myDb.insertPermission("READ_PHONE_STATE");

        return tMgr.getNetworkOperator();
    }

    @SuppressLint("MissingPermission")
    public String getNetworkOperatorName (){
        myDb = new DBHelper(context);
        myDb.insertPermission("READ_PHONE_STATE");

        return tMgr.getNetworkOperatorName();
    }

    @SuppressLint("NewApi")
    public int getSimCarrierId (){
        myDb = new DBHelper(context);
        myDb.insertPermission("READ_PHONE_STATE");

        return tMgr.getSimCarrierId();
    }

    @SuppressLint("NewApi")
    public CharSequence getSimCarrierIdName (){
        myDb = new DBHelper(context);
        myDb.insertPermission("READ_PHONE_STATE");

        return tMgr.getSimCarrierIdName();
    }

    @SuppressLint("MissingPermission")
    public String getSimOperator (){
        myDb = new DBHelper(context);
        myDb.insertPermission("READ_PHONE_STATE");

        return tMgr.getSimOperator();
    }

    @SuppressLint("MissingPermission")
    public String getSimOperatorName (){
        myDb = new DBHelper(context);
        myDb.insertPermission("READ_PHONE_STATE");

        return tMgr.getSimOperatorName();
    }

    public int getSimState (){
        myDb = new DBHelper(context);
        myDb.insertPermission("READ_PHONE_STATE");

        return tMgr.getSimState();
    }

    @SuppressLint("NewApi")
    public int getSimState (int slotIndex){
        myDb = new DBHelper(context);
        myDb.insertPermission("READ_PHONE_STATE");

        return tMgr.getSimState(slotIndex);
    }

    @SuppressLint("MissingPermission")
    public String getVoiceMailNumber (){
        myDb = new DBHelper(context);
        myDb.insertPermission("READ_PHONE_STATE");

        return tMgr.getVoiceMailNumber();
    }

    @SuppressLint("NewApi")
    public boolean isDataEnabled (){
        myDb = new DBHelper(context);
        myDb.insertPermission("READ_PHONE_STATE");

        return tMgr.isDataEnabled();
    }

    public void setDataEnabled (boolean enable){
        myDb = new DBHelper(context);
        myDb.insertPermission("READ_PHONE_STATE");

        setDataEnabled(enable);
    }
}
