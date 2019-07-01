package com.example.securedroid;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.widget.Toast;

//For call logs, contacts and calendar
public class SecContentResolver {

    DBHelper myDb;
    Context context;
    ContentResolver contentResolver;
    Cursor cursor;
    Uri uri;
    String allPermissions;
    int rowsDeleted;

    public SecContentResolver(Context context){
        contentResolver = context.getApplicationContext().getContentResolver();
        this.context = context;
    }

    public final Cursor query (Uri uri, String[] projection, Bundle queryArgs, CancellationSignal cancellationSignal) {
        if(uri.toString().contains("call_log/calls")) { //CallLog.Calls.CONTENT_URI
            myDb = new DBHelper(context);
            myDb.insertPermission("READ_CALL_LOG");
        }
        if(uri.toString().contains("com.android.contacts/data")) { //ContactsContract.Data.CONTENT_URI OR ContactsContract.Contacts.CONTENT_URI
            myDb = new DBHelper(context);
            myDb.insertPermission("READ_CONTACTS");
        }
        if(uri.toString().contains("com.android.calendar")) { //CalendarContract.Calendars.CONTENT_URI or CalendarContract.Events.CONTENT_URI
            myDb = new DBHelper(context);
            myDb.insertPermission("READ_CALENDAR");
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            cursor = contentResolver.query(uri, projection, queryArgs, cancellationSignal);
        }
        return cursor;
    }

    public final Cursor query (Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder, CancellationSignal cancellationSignal){
        if(uri.toString().contains("call_log/calls")) {
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
        cursor = contentResolver.query(uri, projection, selection, selectionArgs, sortOrder, cancellationSignal);
        return cursor;
    }

    public final Cursor query (Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder){
        if(uri.toString().contains("call_log/calls")) {
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
        cursor = contentResolver.query(uri, projection, selection, selectionArgs, sortOrder);
        return cursor;
    }

    public final Uri insert (final Uri url, final ContentValues values){
        uri = null;
        if(url.toString().contains("call_log/calls")) {
            myDb = new DBHelper(context);
            allPermissions = myDb.getAllPermissions();

            final Handler handler = new Handler()
            {
                @Override
                public void handleMessage(Message mesg)
                {
                    throw new RuntimeException();
                }
            };

            AlertDialog.Builder alert = new AlertDialog.Builder(context);
            alert.setTitle("Are you sure?");
            alert.setMessage("The application has been influenced by following permissions recently:\n" + allPermissions + " It wants to insert a number to Call Log.");
            alert.setPositiveButton("Continue", new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int id)
                {
                    uri = contentResolver.insert(url, values);
                    Toast.makeText(context, "Call Log influenced", Toast.LENGTH_SHORT).show();
                    handler.sendMessage(handler.obtainMessage());
                }
            });
            alert.setNegativeButton("No", new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int id)
                {
                    Toast.makeText(context, "Call Log not influenced", Toast.LENGTH_SHORT).show();
                    handler.sendMessage(handler.obtainMessage());
                }
            });
            alert.show();

            try{ Looper.loop(); }
            catch(RuntimeException e){}
        }
        if(url.toString().contains("com.android.contacts/data")) {
            myDb = new DBHelper(context);
            allPermissions = myDb.getAllPermissions();

            final Handler handler = new Handler()
            {
                @Override
                public void handleMessage(Message mesg)
                {
                    throw new RuntimeException();
                }
            };

            AlertDialog.Builder alert = new AlertDialog.Builder(context);
            alert.setTitle("Are you sure?");
            alert.setMessage("The application has been influenced by following permissions recently:\n" + allPermissions + " It wants to insert a Contact.");
            alert.setPositiveButton("Continue", new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int id)
                {
                    uri = contentResolver.insert(url, values);
                    Toast.makeText(context, "Contacts influenced", Toast.LENGTH_SHORT).show();
                    handler.sendMessage(handler.obtainMessage());
                }
            });
            alert.setNegativeButton("No", new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int id)
                {
                    Toast.makeText(context, "Contacts not influenced", Toast.LENGTH_SHORT).show();
                    handler.sendMessage(handler.obtainMessage());
                }
            });
            alert.show();

            try{ Looper.loop(); }
            catch(RuntimeException e){}
        }
        if(url.toString().contains("com.android.calendar")) {
            myDb = new DBHelper(context);
            allPermissions = myDb.getAllPermissions();

            final Handler handler = new Handler()
            {
                @Override
                public void handleMessage(Message mesg)
                {
                    throw new RuntimeException();
                }
            };

            AlertDialog.Builder alert = new AlertDialog.Builder(context);
            alert.setTitle("Are you sure?");
            alert.setMessage("The application has been influenced by following permissions recently:\n" + allPermissions + " It wants to add an event to Calendar.");
            alert.setPositiveButton("Continue", new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int id)
                {
                    uri = contentResolver.insert(url, values);
                    Toast.makeText(context, "Calendar influenced", Toast.LENGTH_SHORT).show();
                    handler.sendMessage(handler.obtainMessage());
                }
            });
            alert.setNegativeButton("No", new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int id)
                {
                    Toast.makeText(context, "Calendar not influenced", Toast.LENGTH_SHORT).show();
                    handler.sendMessage(handler.obtainMessage());
                }
            });
            alert.show();

            try{ Looper.loop(); }
            catch(RuntimeException e){}
        }
        return uri;
    }

    public final int delete (final Uri url, final String where, final String[] selectionArgs){
        rowsDeleted = 0;
        if(url.toString().contains("call_log/calls")) {
            myDb = new DBHelper(context);
            allPermissions = myDb.getAllPermissions();

            final Handler handler = new Handler()
            {
                @Override
                public void handleMessage(Message mesg)
                {
                    throw new RuntimeException();
                }
            };

            AlertDialog.Builder alert = new AlertDialog.Builder(context);
            alert.setTitle("Are you sure?");
            alert.setMessage("The application has been influenced by following permissions recently:\n" + allPermissions + " It wants to delete a number from Call Log.");
            alert.setPositiveButton("Continue", new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int id)
                {
                    rowsDeleted = contentResolver.delete(url, where, selectionArgs);
                    Toast.makeText(context, "Call Log influenced", Toast.LENGTH_SHORT).show();
                    handler.sendMessage(handler.obtainMessage());
                }
            });
            alert.setNegativeButton("No", new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int id)
                {
                    Toast.makeText(context, "Call Log not influenced", Toast.LENGTH_SHORT).show();
                    handler.sendMessage(handler.obtainMessage());
                }
            });
            alert.show();

            try{ Looper.loop(); }
            catch(RuntimeException e){}

        }
        if(url.toString().contains("com.android.contacts/data")) {
            myDb = new DBHelper(context);
            allPermissions = myDb.getAllPermissions();

            final Handler handler = new Handler()
            {
                @Override
                public void handleMessage(Message mesg)
                {
                    throw new RuntimeException();
                }
            };

            AlertDialog.Builder alert = new AlertDialog.Builder(context);
            alert.setTitle("Are you sure?");
            alert.setMessage("The application has been influenced by following permissions recently:\n" + allPermissions + " It wants to delete a Contact.");
            alert.setPositiveButton("Continue", new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int id)
                {
                    rowsDeleted = contentResolver.delete(url, where, selectionArgs);
                    Toast.makeText(context, "Contacts influenced", Toast.LENGTH_SHORT).show();
                    handler.sendMessage(handler.obtainMessage());
                }
            });
            alert.setNegativeButton("No", new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int id)
                {
                    Toast.makeText(context, "Contacts not influenced", Toast.LENGTH_SHORT).show();
                    handler.sendMessage(handler.obtainMessage());
                }
            });
            alert.show();

            try{ Looper.loop(); }
            catch(RuntimeException e){}
        }
        if(url.toString().contains("com.android.calendar")) {
            myDb = new DBHelper(context);
            allPermissions = myDb.getAllPermissions();

            final Handler handler = new Handler()
            {
                @Override
                public void handleMessage(Message mesg)
                {
                    throw new RuntimeException();
                }
            };

            AlertDialog.Builder alert = new AlertDialog.Builder(context);
            alert.setTitle("Are you sure?");
            alert.setMessage("The application has been influenced by following permissions recently:\n" + allPermissions + " It wants to delete an event from Calendar.");
            alert.setPositiveButton("Continue", new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int id)
                {
                    rowsDeleted = contentResolver.delete(url, where, selectionArgs);
                    Toast.makeText(context, "Calendar influenced", Toast.LENGTH_SHORT).show();
                    handler.sendMessage(handler.obtainMessage());
                }
            });
            alert.setNegativeButton("No", new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int id)
                {
                    Toast.makeText(context, "Calendar not influenced", Toast.LENGTH_SHORT).show();
                    handler.sendMessage(handler.obtainMessage());
                }
            });
            alert.show();

            try{ Looper.loop(); }
            catch(RuntimeException e){}
        }
        return rowsDeleted;
    }

}
