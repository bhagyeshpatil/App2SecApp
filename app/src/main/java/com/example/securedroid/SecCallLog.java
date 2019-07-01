package com.example.securedroid;

import android.content.Context;
import android.provider.CallLog;

//For call logs
public class SecCallLog {

    Context context;
    static DBHelper myDb;

    public SecCallLog(Context context) {
        this.context = context;
    }

    public static String getLastOutgoingCall (Context context) {
        myDb = new DBHelper(context);
        myDb.insertPermission("READ_CALL_LOG");

        return CallLog.Calls.getLastOutgoingCall(context);
    }

}
