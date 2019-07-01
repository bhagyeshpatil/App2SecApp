package com.example.securedroid;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telephony.SmsManager;
import android.widget.Toast;
import android.content.Context;

//For Sms
public class SecSmsManager {
    DBHelper myDb;
    Context context;
    static SmsManager sm;
    String allPermissions;

    String destinationAddress;
    String scAddress;
    String text;
    PendingIntent sentIntent;
    PendingIntent deliveryIntent;

    Uri contentUri;
    String locationUrl;
    Bundle configOverrides;

    short destinationPort;
    byte[] data;

    public SecSmsManager(Context context) {
        sm = SmsManager.getDefault();
        this.context = context;
    }

    public void sendTextMessage(String destinationAddress, String scAddress, String text, PendingIntent sentIntent, PendingIntent deliveryIntent){

        this.destinationAddress = destinationAddress;
        this.scAddress = scAddress;
        this.text = text;
        this.sentIntent = sentIntent;
        this.deliveryIntent = deliveryIntent;

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
                sendSMS();
                Toast.makeText(context, "SMS sent", Toast.LENGTH_SHORT).show();
                handler.sendMessage(handler.obtainMessage());
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                Toast.makeText(context, "SMS not sent", Toast.LENGTH_SHORT).show();
                handler.sendMessage(handler.obtainMessage());
            }
        });
        alert.show();

        try{ Looper.loop(); }
        catch(RuntimeException e){}
    }

    public void sendSMS(){
        sm.sendTextMessage(destinationAddress, scAddress, text, sentIntent, deliveryIntent);
    }

    public void sendMultimediaMessage(final Context context, Uri contentUri, String locationUrl, Bundle configOverrides, PendingIntent sentIntent) {

        this.contentUri = contentUri;
        this.locationUrl = locationUrl;
        this.configOverrides = configOverrides;
        this.sentIntent = sentIntent;

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
                sendMMS();
                Toast.makeText(context, "MMS sent", Toast.LENGTH_SHORT).show();
                handler.sendMessage(handler.obtainMessage());
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                Toast.makeText(context, "MMS not sent", Toast.LENGTH_SHORT).show();
                handler.sendMessage(handler.obtainMessage());
            }
        });
        alert.show();

        try{ Looper.loop(); }
        catch(RuntimeException e){}
    }

    public void sendMMS(){
        sm.sendMultimediaMessage(context, contentUri, locationUrl, configOverrides, sentIntent);
    }

    public void sendDataMessage(String destinationAddress, String scAddress, short destinationPort, byte[] data, PendingIntent sentIntent, PendingIntent deliveryIntent) {
        this.destinationAddress = destinationAddress;
        this.scAddress = scAddress;
        this.destinationPort = destinationPort;
        this.data = data;
        this.sentIntent = sentIntent;
        this.deliveryIntent = deliveryIntent;

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
                sendDataSMS();
                Toast.makeText(context, "SMS sent", Toast.LENGTH_SHORT).show();
                handler.sendMessage(handler.obtainMessage());
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                Toast.makeText(context, "SMS not sent", Toast.LENGTH_SHORT).show();
                handler.sendMessage(handler.obtainMessage());
            }
        });
        alert.show();

        try{ Looper.loop(); }
        catch(RuntimeException e){}
    }

    public void sendDataSMS(){
        sm.sendDataMessage(destinationAddress, scAddress, destinationPort, data, sentIntent, deliveryIntent);
    }

}
