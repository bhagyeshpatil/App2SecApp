package com.example.securedroid;

import android.content.Context;
import android.content.CursorLoader;
import android.net.Uri;

//For call logs, contacts and calendar
public class SecCursorLoader {

    DBHelper myDb;
    Context context;
    CursorLoader cursorLoader;

    public SecCursorLoader(Context context, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder){

        this.context = context;

        if(uri.toString().contains("call_log/calls")){
            myDb = new DBHelper(context);
            myDb.insertPermission("READ_CALL_LOG");
        }
        if(uri.toString().contains("com.android.contacts/data")) {
            myDb = new DBHelper(context);
            myDb.insertPermission("READ_CONTACTS");
        }
        if(uri.toString().contains("com.android.calendar")) {
            myDb = new DBHelper(context);
            myDb.insertPermission("READ_CALENDAR");
        }

        cursorLoader = new CursorLoader(context, uri, projection, selection, selectionArgs, sortOrder);
    }

    public SecCursorLoader(Context context){
        cursorLoader = new CursorLoader(context);
    }

}
