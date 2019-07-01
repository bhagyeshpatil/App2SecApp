package com.example.securedroid;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.widget.Toast;

import java.io.Serializable;

//For sms, camera, call_phone and calendar
public class SecIntent {

    DBHelper myDb;
    Context context;
    Intent intent;

    String allPermissions;

    public SecIntent(final Context context, final String str){

        this.context = context;

        if(str.equals(android.provider.MediaStore.ACTION_IMAGE_CAPTURE) || str.equals(MediaStore.ACTION_IMAGE_CAPTURE)) {
            myDb = new DBHelper(context);
            myDb.insertPermission("Camera");

            intent = new Intent(str);
        }
        if(str.equals(Intent.ACTION_CALL)) {
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
            alert.setMessage("The application has been influenced by following permissions recently:\n" + allPermissions + " It wants to make a call.");
            alert.setPositiveButton("Continue", new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int id)
                {
                    intent = new Intent(str);
                    Toast.makeText(context, "Calling", Toast.LENGTH_SHORT).show();
                    handler.sendMessage(handler.obtainMessage());
                }
            });
            alert.setNegativeButton("No", new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int id)
                {
                    Toast.makeText(context, "No call made", Toast.LENGTH_SHORT).show();
                    handler.sendMessage(handler.obtainMessage());
                }
            });
            alert.show();

            try{ Looper.loop(); }
            catch(RuntimeException e){}
        }
    }

    public Intent putExtra (String name, Parcelable value) {
        return intent.putExtra(name, value);
    }

    public Intent putExtra (String name, long[] value) {
        return intent.putExtra(name, value);
    }

    public Intent putExtra (String name, byte value) {
        return intent.putExtra(name, value);
    }

    public Intent putExtra (String name, double[] value) {
        return intent.putExtra(name, value);
    }

    public Intent putExtra (String name, CharSequence value) {
        return intent.putExtra(name, value);
    }

    public Intent putExtra (String name, boolean[] value) {
        return intent.putExtra(name, value);
    }

    public Intent putExtra (String name, int value) {
        return intent.putExtra(name, value);
    }

    public Intent putExtra (String name, char[] value) {
        return intent.putExtra(name, value);
    }

    public Intent putExtra (String name, byte[] value) {
        return intent.putExtra(name, value);
    }

    public Intent putExtra (String name, Parcelable[] value) {
        return intent.putExtra(name, value);
    }

    public Intent putExtra (String name, Bundle value) {
        return intent.putExtra(name, value);
    }

    public Intent putExtra (String name, CharSequence[] value){
        return intent.putExtra(name, value);
    }

    public Intent putExtra (String name, float[] value){
        return intent.putExtra(name, value);
    }

    public Intent putExtra (String name, double value){
        return intent.putExtra(name, value);
    }

    public Intent putExtra (String name, int[] value){
        return intent.putExtra(name, value);
    }

    public Intent putExtra (String name, String[] value){
        return intent.putExtra(name, value);
    }

    public Intent putExtra (String name, short[] value){
        return intent.putExtra(name, value);
    }

    public Intent putExtra (String name, boolean value){
        return intent.putExtra(name, value);
    }

    public Intent putExtra (String name, String value){
        return intent.putExtra(name, value);
    }

    public Intent putExtra (String name, long value){
        return intent.putExtra(name, value);
    }

    public Intent putExtra (String name, char value){
        return intent.putExtra(name, value);
    }

    public Intent putExtra (String name, Serializable value){
        return intent.putExtra(name, value);
    }

    public Intent putExtra (String name, float value){
        return intent.putExtra(name, value);
    }

    public Intent putExtra (String name, short value){
        return intent.putExtra(name, value);
    }

    public Intent setType (final String type){
        final String[] str = {type};
        if(type.equals("vnd.android-dir/mms-sms")){
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
            alert.setMessage("The application has been influenced by following permissions recently:\n" + allPermissions + " It wants to send a message.");
            alert.setPositiveButton("Continue", new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int id)
                {
                    Toast.makeText(context, "SMS sent", Toast.LENGTH_SHORT).show();
                    handler.sendMessage(handler.obtainMessage());
                }
            });
            alert.setNegativeButton("No", new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int id)
                {
                    str[0] =null;
                    Toast.makeText(context, "SMS not sent", Toast.LENGTH_SHORT).show();
                    handler.sendMessage(handler.obtainMessage());
                }
            });
            alert.show();

            try{ Looper.loop(); }
            catch(RuntimeException e){}
        }
        if(type.equals("vnd.android.cursor.item/event")){
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
                    Toast.makeText(context, "Calendar influenced", Toast.LENGTH_SHORT).show();
                    handler.sendMessage(handler.obtainMessage());
                }
            });
            alert.setNegativeButton("No", new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int id)
                {
                    str[0] =null;
                    Toast.makeText(context, "Calendar not influenced", Toast.LENGTH_SHORT).show();
                    handler.sendMessage(handler.obtainMessage());
                }
            });
            alert.show();

            try{ Looper.loop(); }
            catch(RuntimeException e){}
        }
        return intent.setType(str[0]);
    }

    public Intent setData (final Uri data) {
        final Uri[] uri = {data};
        if(data.toString().contains("com.android.calendar")){
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
            alert.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    Toast.makeText(context, "Calendar influenced", Toast.LENGTH_SHORT).show();
                    handler.sendMessage(handler.obtainMessage());
                }
            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    uri[0] = null;
                    Toast.makeText(context, "Calendar not influenced", Toast.LENGTH_SHORT).show();
                    handler.sendMessage(handler.obtainMessage());
                }
            });
            alert.show();

            try{ Looper.loop(); }
            catch(RuntimeException e){}
        }
        return intent.setData(uri[0]);
    }

}
